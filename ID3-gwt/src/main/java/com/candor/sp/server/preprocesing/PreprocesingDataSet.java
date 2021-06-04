package com.candor.sp.server.preprocesing;

import com.candor.sp.shared.DataFraud;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PreprocesingDataSet {
    public static void main(String[] args) {
        List<DataFraud> list = null;

        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/com/candor/sp/data/insurance_claims.csv"));

            // create csv bean reader
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DataFraud.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            list = getListFromIterator(((Iterable<DataFraud>) csvToBean).iterator());

            list.stream().forEach(el -> {
                //MONTH_AS_CUSTOMER ON CATEGORIES (newCustomer, customer, oldCustomer)
                int val = Integer.parseInt(el.getMonths_as_customer());
                if (val < 25) {
                    el.setMonths_as_customer("newCustomer");
                } else if (val >= 25 && val <= 200) {
                    el.setMonths_as_customer("customer");
                } else
                    el.setMonths_as_customer("oldCustomer");

                //AGE ON CATEGORIES (Young, Mature, Old)
                int age = Integer.parseInt(el.getAge());
                if (age <= 25)
                    el.setAge("Young");
                else if (age > 25 && age < 50)
                    el.setAge("Mature");
                else
                    el.setAge("Old");

                //Policy_deductable ON CATEGORIES (low, mid, high)
                int policy_deductable = Integer.parseInt(el.getPolicy_deductable());
                if (policy_deductable == 500)
                    el.setPolicy_deductable("low");
                else if (policy_deductable == 1000)
                    el.setPolicy_deductable("mid");
                else
                    el.setPolicy_deductable("high");

                //umbrella_limit ON CATEGORIES (err, basic, gold, premium)
                int umbrella_limit = Integer.parseInt(el.getUmbrella_limit());
                if (umbrella_limit <= 0)
                    el.setUmbrella_limit("err");
                else if (umbrella_limit <= 3000000)
                    el.setUmbrella_limit("basic");
                else if (umbrella_limit <= 6000000)
                    el.setUmbrella_limit("gold");
                else
                    el.setUmbrella_limit("premium");

                //number_of_vehicles_involved ON CATEGORIES (one, two, three, four)
                int number_of_vehicles_involved = Integer.parseInt(el.getNumber_of_vehicles_involved());
                if (number_of_vehicles_involved == 1)
                    el.setNumber_of_vehicles_involved("one");
                else if (number_of_vehicles_involved == 2)
                    el.setNumber_of_vehicles_involved("two");
                else if (number_of_vehicles_involved == 3)
                    el.setNumber_of_vehicles_involved("three");
                else
                    el.setNumber_of_vehicles_involved("four");

                //instead of ? set unknown
                if (el.getProperty_damage().equals("?"))
                    el.setProperty_damage("unknown");

                if (el.getCollision_type().equals("?"))
                    el.setCollision_type("unknown");

                //bodily_injuries ON CATEGORIES (zero, one, two)
                int bodily_injuries = Integer.parseInt(el.getBodily_injuries());
                if (bodily_injuries == 0)
                    el.setBodily_injuries("zero");
                else if (bodily_injuries == 1)
                    el.setBodily_injuries("one");
                else if (bodily_injuries == 2)
                    el.setBodily_injuries("two");

                //witnesses ON CATEGORIES (zero, one, two, three)
                int witnesses = Integer.parseInt(el.getWitnesses());
                if (bodily_injuries == 0)
                    el.setWitnesses("zero");
                else if (bodily_injuries == 1)
                    el.setWitnesses("one");
                else if (bodily_injuries == 2)
                    el.setWitnesses("two");
                else
                    el.setWitnesses("three");

                //witnesses ON CATEGORIES (very old, old, recent, almost new)
                int autoYear = Integer.parseInt(el.getAuto_year());
                if (autoYear < 2000)
                    el.setAuto_year("very old");
                else if (autoYear < 2006)
                    el.setAuto_year("old");
                else if (autoYear < 2011)
                    el.setAuto_year("recent");
                else
                    el.setAuto_year("almost new");

                //instead of ? set unknown
                if (el.getPolice_report_available().equals("?"))
                    el.setPolice_report_available("unknown");

                //total_claim_amount ON CATEGORIES (very low, low, decent, good, high, premium)
                int total_claim_amount = Integer.parseInt(el.getTotal_claim_amount());
                if (total_claim_amount < 1000)
                    el.setTotal_claim_amount("very low");
                else if (total_claim_amount < 5000)
                    el.setTotal_claim_amount("low");
                else if (total_claim_amount < 10000)
                    el.setTotal_claim_amount("decent");
                else if (total_claim_amount < 50000)
                    el.setTotal_claim_amount("good");
                else if (total_claim_amount < 100000)
                    el.setTotal_claim_amount("high");
                else
                    el.setTotal_claim_amount("premium");

                //vehicle_claim ON CATEGORIES (very low, low, decent, expensive,very expensive)
                int vehicle_claim = Integer.parseInt(el.getVehicle_claim());
                if (vehicle_claim < 1000)
                    el.setVehicle_claim("very low");
                else if (vehicle_claim < 5000)
                    el.setVehicle_claim("low");
                else if (vehicle_claim < 10000)
                    el.setVehicle_claim("decent");
                else if (vehicle_claim < 50000)
                    el.setVehicle_claim("expensive");
                else
                    el.setVehicle_claim("very expensive");


                //injury_claim ON CATEGORIES (very low, low, decent, expensive,very expensive)
                int injury_claim = Integer.parseInt(el.getInjury_claim());
                if (injury_claim < 1000)
                    el.setInjury_claim("very low");
                else if (injury_claim < 5000)
                    el.setInjury_claim("low");
                else if (injury_claim < 10000)
                    el.setInjury_claim("decent");
                else if (injury_claim < 15000)
                    el.setInjury_claim("expensive");
                else
                    el.setInjury_claim("very expensive");

                //property_claim
                //property_claim ON CATEGORIES (very low, low, decent, expensive,very expensive)
                int property_claim = Integer.parseInt(el.getProperty_claim());
                if (property_claim < 1000)
                    el.setProperty_claim("very low");
                else if (property_claim < 5000)
                    el.setProperty_claim("low");
                else if (property_claim < 10000)
                    el.setProperty_claim("decent");
                else if (property_claim < 15000)
                    el.setProperty_claim("expensive");
                else
                    el.setProperty_claim("very expensive");


                //capital_loss ON CATEGORIES (very low, low, decent, expensive,very expensive)
                int capital_loss = Optional.ofNullable(el.getCapital_loss()).map(eli -> Integer.parseInt(eli)).orElse(0);
                if (capital_loss > -1000)
                    el.setCapital_loss("very low");
                else if (capital_loss > -5000)
                    el.setCapital_loss("low");
                else if (capital_loss > -10000)
                    el.setCapital_loss("decent");
                else if (capital_loss > -50000)
                    el.setCapital_loss("expensive");
                else
                    el.setCapital_loss("very expensive");

                //capital_gains ON CATEGORIES (very low, low, decent, good, high, premium)
                int capital_gains = Optional.ofNullable(el.getCapital_gains()).map(eli -> Integer.parseInt(eli)).orElse(0);
                if (capital_gains < 10000)
                    el.setCapital_gains("very low");
                else if (capital_gains < 20000)
                    el.setCapital_gains("low");
                else if (capital_gains < 40000)
                    el.setCapital_gains("decent");
                else if (capital_gains < 60000)
                    el.setCapital_gains("good");
                else if (capital_gains < 80000)
                    el.setCapital_gains("high");
                else
                    el.setCapital_gains("premium");

                //capital_gains ON CATEGORIES (very low, low, decent, good, high, premium)
                double getPolicy_annual_premium = Double.parseDouble(el.getPolicy_annual_premium());
                if (getPolicy_annual_premium < 1000)
                    el.setPolicy_annual_premium("min");
                else if (getPolicy_annual_premium < 1500)
                    el.setPolicy_annual_premium("normal");
                else
                    el.setPolicy_annual_premium("high");

            });
            // close the reader
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total_claim_amount -> " + list.stream().map(el -> el.getTotal_claim_amount()).distinct().count());
        System.out.println("Fraud_reported -> " + list.stream().map(el -> el.getFraud_reported()).distinct().count());
        System.out.println("Age -> " + list.stream().map(el -> el.getAge()).distinct().count());
        System.out.println("Witnesses -> " + list.stream().map(el -> el.getWitnesses()).distinct().count());
        System.out.println("Auto_year -> " + list.stream().map(el -> el.getAuto_year()).distinct().count());
        System.out.println("Bodily_injuries -> " + list.stream().map(el -> el.getBodily_injuries()).distinct().count());
        System.out.println("Police_report_available -> " + list.stream().map(el -> el.getPolice_report_available()).distinct().count());
        System.out.println("Number_of_vehicles_involved -> " + list.stream().map(el -> el.getNumber_of_vehicles_involved()).distinct().count());
        System.out.println("Property_damage -> " + list.stream().map(el -> el.getProperty_damage()).distinct().count());
        System.out.println("Vehicle_claim -> " + list.stream().map(el -> el.getVehicle_claim()).distinct().count());
        System.out.println("Policy_annual_premium -> " + list.stream().map(el -> el.getPolicy_annual_premium()).distinct().count());
        System.out.println("Incident_severity -> " + list.stream().map(el -> el.getIncident_severity()).distinct().count());
        System.out.println("Insured_hobbies -> " + list.stream().map(el -> el.getInsured_hobbies()).distinct().count());
        System.out.println("Insured_relationship -> " + list.stream().map(el -> el.getInsured_relationship()).distinct().count());
        System.out.println("Insured_education_level -> " + list.stream().map(el -> el.getInsured_education_level()).distinct().count());
        System.out.println("Auto_make -> " + list.stream().map(el -> el.getAuto_make()).distinct().count());
        System.out.println("Umbrella_limit -> " + list.stream().map(el -> el.getUmbrella_limit()).distinct().count());
        System.out.println("Injury_claim -> " + list.stream().map(el -> el.getInjury_claim()).distinct().count());
        System.out.println("Collision_type -> " + list.stream().map(el -> el.getCollision_type()).distinct().count());
        System.out.println("Insured_occupation -> " + list.stream().map(el -> el.getInsured_occupation()).distinct().count());
        System.out.println("Property_claim -> " + list.stream().map(el -> el.getProperty_claim()).distinct().count());
        System.out.println("Insured_sex -> " + list.stream().map(el -> el.getInsured_sex()).distinct().count());
        System.out.println("Capital_gains -> " + list.stream().map(el -> el.getCapital_gains()).distinct().count());
        System.out.println("Capital_loss -> " + list.stream().map(el -> el.getCapital_loss()).distinct().count());
        System.out.println("Months_as_customer -> " + list.stream().map(el -> el.getMonths_as_customer()).distinct().count());
        System.out.println("Authorities_contacted -> " + list.stream().map(el -> el.getAuthorities_contacted()).distinct().count());
        System.out.println("Incident_type -> " + list.stream().map(el -> el.getIncident_type()).distinct().count());

//        list.stream().map(el -> Double.valueOf(el.getPolicy_annual_premium())).distinct().sorted().peek(e -> System.out.println(e)).collect(Collectors.toList());
        int MinorDamage = 0;
        int TotalLoss = 0;
        int MajotDamage = 0;
        int TrivialDamage = 0;

        for (DataFraud el : list.stream().limit(700).collect(Collectors.toList())) {
            if (el.getIncident_severity().equals("Minor Damage")) {
                MinorDamage++;
            } else if (el.getIncident_severity().equals("Major Damage"))
                MajotDamage++;
            else if (el.getIncident_severity().equals("Trivial Damage"))
                TrivialDamage++;
            else if (el.getIncident_severity().equals("Total Loss"))
                TotalLoss++;
        }

        System.out.println("-> Minor:" + MinorDamage + " Major:" + MajotDamage + " Trivial:" + TrivialDamage + " Total:" + TotalLoss);
        System.out.println("COUNT positive Minor: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Minor Damage") && el.getFraud_reported().equals("Y")).count());
        System.out.println("COUNT negative Minor: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Minor Damage") && el.getFraud_reported().equals("N")).count());

        System.out.println("COUNT positive Major: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Major Damage") && el.getFraud_reported().equals("Y")).count());
        System.out.println("COUNT negative Major: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Major Damage") && el.getFraud_reported().equals("N")).count());

        System.out.println("COUNT positive Trivial: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Trivial Damage") && el.getFraud_reported().equals("Y")).count());
        System.out.println("COUNT negative Trivial: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Trivial Damage") && el.getFraud_reported().equals("N")).count());

        System.out.println("COUNT positive Total: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Total Loss") && el.getFraud_reported().equals("Y")).count());
        System.out.println("COUNT negative Total: " + list.stream().limit(700).filter(el -> el.getIncident_severity().equals("Total Loss") && el.getFraud_reported().equals("N")).count());


        System.out.println("Insured hobbies - Board games");
        System.out.println("-> " + list.stream().limit(700).filter(el -> el.getInsured_hobbies().equals("board-games")).count());

        System.out.println("Insured hobbies - Board games");
        System.out.println("-> " + list.stream().limit(700).filter(el -> el.getInsured_hobbies().equals("dancing") && el.getFraud_reported().equals("Y")).count());
        System.out.println("-> " + list.stream().limit(700).filter(el -> el.getInsured_hobbies().equals("dancing") && el.getFraud_reported().equals("N")).count());

        List<DataFraud> trainingList = list.stream().limit(700L).collect(Collectors.toList());
        list.removeAll(trainingList);
        System.out.println("TOTAL fraud in test data: " + list.stream().filter(el -> el.getFraud_reported().equals("Y")).count() + " - " + list.size());
        System.out.println("TOTAL fraud in training data: " + trainingList.stream().filter(el -> el.getFraud_reported().equals("Y")).count() + " - " + list.size());
        writeListAsCSV(trainingList, true);
        writeListAsCSV(list, false);
    }

    public static void writeListAsCSV(List<DataFraud> list, boolean isTraining) {
        try {
            // create a write
            Writer writer = null;
            if (isTraining)
                writer = Files.newBufferedWriter(Paths.get("ID3-gwt/src/main/resources/com/candor/sp/data/myDataSetNEW.csv"));
            else
                writer = Files.newBufferedWriter(Paths.get("ID3-gwt/src/main/resources/com/candor/sp/data/testDataNEW.csv"));


            // create a csv writer
            StatefulBeanToCsv<DataFraud> csvWriter = new StatefulBeanToCsvBuilder<DataFraud>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                    .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .withOrderedResults(false)
                    .build();

            // write list of objects
            csvWriter.write(list);

            // close the writer
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Function to get the List
    public static <T> List<T>
    getListFromIterator(Iterator<T> iterator) {

        // Create an empty list
        List<T> list = new ArrayList<>();

        // Add each element of iterator to the List
        iterator.forEachRemaining(list::add);

        // Return the List
        return list;
    }
}
