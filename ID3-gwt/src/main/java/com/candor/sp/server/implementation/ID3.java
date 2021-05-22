package com.candor.sp.server.implementation;

import com.candor.sp.server.model.DataFraud;
import com.candor.sp.shared.GainType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ID3 {
    final double LOG2 = Math.log(2.0);
    private DecimalFormat df2 = new DecimalFormat("#.###");
    private List<DataFraud> dataSet = new ArrayList<>();
    private List<String> dataSetCols = new ArrayList<>();
    private PrintTree p = new PrintTree();
    private String decisionColumn = "Fraud_reported";
    private boolean withGainRatio = true;
    private int correct_predictions = 0;

    private List<DataFraud> testData = new ArrayList<>();
    private int amIntrat = 0;

    public String createTree(String gainType) throws IOException {
        if (gainType.equals(GainType.GAIN_RATIO.getValue()))
            withGainRatio = true;
        else
            withGainRatio = false;

        setList();
        setTestData();

        dataSetCols = Arrays.stream(DataFraud.class.getMethods()).filter(f -> f.getName().contains("set")).map(m -> m.getName().replace("set", "")).sorted().collect(Collectors.toList());
        dataSetCols.remove(decisionColumn);
        String rootAttr = getRootNode(dataSet, decisionColumn, dataSetCols, withGainRatio);
        dataSetCols.remove(decisionColumn);
        dataSetCols.remove(rootAttr);
        TreeNode tree = new TreeNode(new Attribute(rootAttr, getAttrValues(dataSet, rootAttr)));

        computeTree(dataSet, tree, dataSetCols, withGainRatio);

        testData.forEach(test -> {
            testIfISFraud(test, tree);
        });

        return p.getJSON(tree);
    }

    private void testIfISFraud(DataFraud testData, TreeNode decisionTree) {
        Optional.ofNullable(decisionTree).ifPresent(tree -> {
            if (tree.getType().equals("root")) {
                String value = testData.getValueByColName(tree.getAttribute().getName());
                testIfISFraud(testData, tree.getChildren().get(value));
            } else {
                if (testData.getFraud_reported().equals(tree.getTargetLabel())) {
                    correct_predictions++;
                }
            }
        });
    }

    private void computeTree(List<DataFraud> ds, TreeNode rootNode, List<String> columns, boolean withGainRatio) {
        rootNode.getAttribute().getValues().forEach(subset -> {
            List<DataFraud> ss = ds.stream().filter(f -> f.getValueByColName(rootNode.getAttribute().getName()).equals(subset)).collect(Collectors.toList());
            String rootNodeName = getRootNode(ss, rootNode.getAttribute().getName(), columns, withGainRatio);
            if (rootNodeName.isEmpty()) {
                double pos = ss.stream().filter(data -> data.getFraud_reported().equals("Y")).count();
                TreeNode leaf = null;
                if (pos > 0)
                    leaf = new TreeNode("Y");
                else
                    leaf = new TreeNode("N");

                rootNode.addChild(subset, leaf);
            } else {
                try {
                    TreeNode root = new TreeNode(new Attribute(rootNodeName, getAttrValues(ds, rootNodeName)));
                    rootNode.addChild(subset, root);
                    List<String> cols = new ArrayList<>();
                    cols.addAll(columns);
                    cols.remove(rootNode.getAttribute().getName());
                    computeTree(ss, root, cols, withGainRatio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public List<String> getAttrValues(String columnName) {
        return dataSet.stream().map(m -> m.getValueByColName(columnName)).distinct().collect(Collectors.toList());
    }

    private List<String> getAttrValues(List<DataFraud> ds, String columnName) {
        return ds.stream().map(m -> m.getValueByColName(columnName)).distinct().collect(Collectors.toList());
    }

    private String getRootNode(List<DataFraud> ds, String decisionCol, List<String> cols, boolean withGainRatio) {
        Map<Double, String> ig = new TreeMap<>();

        List<String> allColumns = new ArrayList<>();
        allColumns.addAll(cols);
        allColumns.remove(decisionCol);

        double dataSetEntropy = dataSetEntropy(ds);
        allColumns.forEach(col -> {
            if (withGainRatio) {
                double gainRatio = getGAIN(ds, col, dataSetEntropy) / calculateSplitInformation(ds, col);
                ig.put(gainRatio, col);
            } else
                ig.put(getGAIN(ds, col, dataSetEntropy), col);
        });

        double maxIG = ig.keySet().stream().mapToDouble(v -> v).max().orElse(0);

        return maxIG == 0 ? "" : ig.get(maxIG);
    }

    //this method calculate gain for a specific column from a dataset
    private Double getGAIN(List<DataFraud> ds, String col, double dataSetEntropy) {
        return Double.parseDouble(df2.format(dataSetEntropy - getInfoEntropy(ds, col)));//-infoEntropy
    }

    //this method calculate info gain for a specific column in a specific dataset
    private double getInfoEntropy(List<DataFraud> ds, String col) {
        AtomicReference<Double> infoEntropy = new AtomicReference<>();
        infoEntropy.set((double) 0);
        getAttrValues(ds, col).forEach(val -> {
            infoEntropy.updateAndGet(v -> new Double((double) (v + getAttributeEntropy(ds, col, val))));
        });

        return infoEntropy.get();
    }

    //this method calulate entropy of a value of an attribut
    private double getAttributeEntropy(List<DataFraud> ds, String decisionColumn, String value) {
        List<DataFraud> sunny = ds.stream().filter(data -> data.getValueByColName(decisionColumn).equals(value)).collect(Collectors.toList());
        double pos = sunny.stream().filter(data -> data.getFraud_reported().equals("Y")).count();
        double neg = sunny.stream().filter(data -> data.getFraud_reported().equals("N")).count();
        return ((pos + neg) / ds.size()) * calculateEntropy(pos, neg);
    }

    //this method calculate the entropy of a dataset
    private double dataSetEntropy(List<DataFraud> ds) {
        double pos = ds.stream().filter(data -> data.getFraud_reported().equals("Y")).count();
        double neg = ds.stream().filter(data -> data.getFraud_reported().equals("N")).count();
        return calculateEntropy(pos, neg);
    }

    //calculates the entropy
    private double calculateEntropy(double pos, double neg) {
        double total = pos + neg;
        double pozVal = (pos / total);
        double negVal = (neg / total);

        double part1 = pos == 0 ? 0 : (-pos / total) * Math.log(pozVal) / LOG2;
        double part2 = neg == 0 ? 0 : (negVal) * Math.log(negVal) / LOG2;

        return pozVal == 0 || negVal == 0 ? 0 : Double.valueOf(df2.format((part1 - part2)));
    }

    private double calculateSplitInformation(List<DataFraud> ds, String col) {
        List<String> values = ds.stream().map(el -> el.getValueByColName(col)).distinct().collect(Collectors.toList());
        List<SplitInfo> list = new ArrayList<>();

        values.forEach(e -> {
            SplitInfo split = new SplitInfo();
            split.setPoz((int) ds.stream().filter(el -> el.getValueByColName(col).equals(e) && el.getFraud_reported().equals("Y")).count());
            split.setNeg((int) ds.stream().filter(el -> el.getValueByColName(col).equals(e) && el.getFraud_reported().equals("N")).count());
            list.add(split);
        });
        AtomicReference<Double> result = new AtomicReference<>((double) 0);
        list.forEach(el -> {
            result.set(result.get() - getEntropySplitInformation(el.getPoz(), el.getNeg(), ds.size()));
        });
        return Double.valueOf(result.get());
    }

    public double getEntropySplitInformation(double poz, double neg, double allDataset) {
        double total = poz + neg;
        double totalVal = (total / allDataset);
        double part1 = total == 0 ? 0 : totalVal * Math.log(totalVal) / LOG2;
        return Double.valueOf(df2.format(part1));
    }

    // Function to get the List
    public <T> List<T> getListFromIterator(Iterator<T> iterator) {

        // Create an empty list
        List<T> list = new ArrayList<>();

        // Add each element of iterator to the List
        iterator.forEachRemaining(list::add);

        // Return the List
        return list;
    }

    private void setList() throws IOException {
        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/com/candor/sp/data/myDataSet.csv"));

        // create csv bean reader
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(DataFraud.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        dataSet = getListFromIterator(((Iterable<DataFraud>) csvToBean).iterator());
    }

    private void setTestData() throws IOException {
        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/com/candor/sp/data/testData.csv"));

        // create csv bean reader
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(DataFraud.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        testData = getListFromIterator(((Iterable<DataFraud>) csvToBean).iterator());
    }

    class SplitInfo {
        private double poz;
        private double neg;

        public double getPoz() {
            return poz;
        }

        public void setPoz(double poz) {
            this.poz = poz;
        }

        public double getNeg() {
            return neg;
        }

        public void setNeg(double neg) {
            this.neg = neg;
        }
    }

    public List<String> getAllColumnsName(){
        return this.dataSetCols;
    }
}
