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
import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.vaadin.polymer.paper.PaperButtonElement;
import com.vaadin.polymer.vaadin.VaadinComboBoxElement;
import elemental2.core.JsArray;
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
    //create a file upload widget
    final FileUpload fileUpload = new FileUpload();
    //create a FormPanel
    final FormPanel form = new FormPanel();
    @UiField
    protected HTMLElement treeElement;
    @UiField
    protected VaadinComboBoxElement id3type;
    @UiField
    protected PaperButtonElement createTree;
    @UiField
    protected HTMLElement fileUpl;
    @UiField
    protected PaperButtonElement testData;
    @UiField
    protected HTMLElement fields;
    private ID3Presenter presenter;

    public ID3ViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        createTree("{\"name\":\"John\", \"age\":31, \"city\":\"New York\"}");

        initComponents();

        addEventHandlers();
        createUploadForm();
    }

    private void createUploadForm() {
        VerticalPanel panel = new VerticalPanel();

        //create labels
        Label selectLabel = new Label("Select a file:");
        //pass action to the form to point to service handling file
        //receiving operation.
        form.setAction("http://www.tutorialspoint.com/gwt/myFormHandler");
        // set form to use the POST method, and multipart MIME encoding.
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        //add a label
        panel.add(selectLabel);
        //add fileUpload widget
        panel.add(fileUpload);

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                // When the form submission is successfully completed, this
                //event is fired. Assuming the service returned a response
                //of type text/html, we can get the result text here
                Window.alert(event.getResults());
            }
        });

        panel.setSpacing(10);

        // Add form to the root panel.
        form.add(panel);
        fileUpl.appendChild(Js.uncheckedCast(form.getElement()));
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
        JSONObject root = (JSONObject) JSONParser.parseStrict(tree);
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
