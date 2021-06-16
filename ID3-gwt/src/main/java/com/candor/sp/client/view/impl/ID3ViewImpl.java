/**
 *
 */
package com.candor.sp.client.view.impl;

import com.candor.sp.client.jsi.JQuery;
import com.candor.sp.client.presenter.ID3Presenter;
import com.candor.sp.client.treegenerator.JsonTreeViewer;
import com.candor.sp.client.view.ID3View;
import com.candor.sp.shared.DataFraud;
import com.candor.sp.shared.GainType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.PaperButtonElement;
import com.vaadin.polymer.vaadin.VaadinComboBoxElement;
import com.vaadin.polymer.vaadin.VaadinUploadElement;
import elemental2.core.JsArray;
import elemental2.dom.File;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author sp
 *
 */
public class ID3ViewImpl extends Composite implements ID3View {

    private static final ID3ViewImplUiBinder uiBinder = GWT.create(ID3ViewImplUiBinder.class);

    @UiField
    protected HTMLElement treeElement;
    @UiField
    protected VaadinComboBoxElement id3type;
    @UiField
    protected PaperButtonElement createTree;
    @UiField
    protected PaperButtonElement upload;
    @UiField
    protected HTMLElement fileUpl;
    @UiField
    protected PaperButtonElement testData;
    @UiField
    protected static HTMLElement fields;
    private ID3Presenter presenter;

    public ID3ViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        createTree("{\"name\":\"John\", \"age\":31, \"city\":\"New York\"}");

        initComponents();

        addEventHandlers();
//        createUploadForm();

        vaadin_FU();
    }

    public static native void readTextFile(File file)
    /*-{
        var reader = new FileReader();
        reader.onload = function(e) {
            @com.candor.sp.client.view.impl.ID3ViewImpl::fileLoaded(*)(reader.result);
        }
        return reader.readAsText(file);
    }-*/;

    public static void fileLoaded(String fileContents) {
        GWT.log("CONTENT: " + fileContents);
        int i = 0;
        String[] list = fileContents.split(",");
        for (Element element : JQuery.$(fields).children().get()) {
            VaadinComboBoxElement attr = Js.uncheckedCast(element);
            attr.setSelectedItem(Js.uncheckedCast(list[i]));
            i++;
        }
                GWT.log("fileContents.split(\",\") = " + fileContents.split(",").length);
        Arrays.stream(fileContents.split(",")).forEach(el -> {
            
            //AGE,AUTHORITIES_CONTACTED,AUTO_MAKE,AUTO_YEAR,BODILY_INJURIES,CAPITAL_GAINS,CAPITAL_LOSS,COLLISION_TYPE,INCIDENT_SEVERITY,INCIDENT_TYPE,INJURY_CLAIM,INSURED_EDUCATION_LEVEL,INSURED_HOBBIES,INSURED_OCCUPATION,INSURED_RELATIONSHIP,INSURED_SEX,MONTHS_AS_CUSTOMER,NUMBER_OF_VEHICLES_INVOLVED,POLICE_REPORT_AVAILABLE,POLICY_ANNUAL_PREMIUM,POLICY_DEDUCTABLE,POLICY_STATE,PROPERTY_CLAIM,PROPERTY_DAMAGE,TOTAL_CLAIM_AMOUNT,UMBRELLA_LIMIT,VEHICLE_CLAIM,WITNESSES,FRAUD_REPORTED

        });

    }

    private void vaadin_FU() {
        VaadinUploadElement element = Polymer.createElement(VaadinUploadElement.TAG);
        element.addEventListener("upload-finished", evt -> {
            GWT.log("Upload finish");
        });
        upload.addEventListener("click", evt -> {
            GWT.log("Click");
            GWT.log("FU: " + element.getFiles().length);
            if (element.getFiles().length > 0) {
                File[] file = Js.uncheckedCast(element.getFiles());
                GWT.log("Size again: " + file.length);
                GWT.log("FILE1: " + file[0].name);
                GWT.log("F: " + file[0].slice().size);
                GWT.log("Content: " + file[0].toString());
                readTextFile(file[0]);
            }
        });
        fileUpl.appendChild(element);

    }

    private void addEventHandlers() {
        createTree.addEventListener("click", evt -> {
            if (id3type.getSelectedItem() != null)
                presenter.onCreateTable(Js.uncheckedCast(id3type.getSelectedItem()));
            else
                presenter.showPopup("You need to select a gain type");
        });

        testData.addEventListener("click", evt -> {
            DataFraud fr = new DataFraud();
            Arrays.stream(JQuery.$(fields).children().get()).forEach(element -> {
                VaadinComboBoxElement comboBox = Js.uncheckedCast(element);
                fr.putValueByColName(comboBox.getName(), comboBox.getValue());
            });
            presenter.testData(fr);
        });
    }


    private void initComponents() {
        id3type.setLabel("Gain type");
        id3type.setName("GAIN");
        id3type.setAllowCustomValue(true);
        id3type.setItems(new JsArray<>(Arrays.stream(GainType.values()).map(v -> v.getValue()).collect(Collectors.toList()).toArray()));
    }

    @Override
    public void setPresenter(ID3Presenter presenter) {
        this.presenter = presenter;
    }

    public void createTree(String tree) {
        clearTree();
//        JSONObject root = (JSONObject) JSONParser.parseStrict(tree);
        JSONObject root = Js.uncheckedCast(JSONParser.parseStrict(tree));
        this.getElement().getStyle().setOverflow(Style.Overflow.AUTO);

        TreeNode node = new TreeNode();
        treeElement.appendChild(Js.uncheckedCast(node.containerForOtherItems));
        JsonTreeViewer.createTree(node, root);
    }

    private void clearTree() {
        while (treeElement.firstChild != null) {
            treeElement.removeChild(treeElement.firstChild);
        }
    }

    public HTMLElement getFields() {
        return fields;
    }

    interface ID3ViewImplUiBinder extends UiBinder<HTMLPanel, ID3ViewImpl> {
    }

}
