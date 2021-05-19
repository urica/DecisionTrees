/**
 *
 */
package com.candor.sp.client.view.impl;

import com.candor.sp.client.presenter.ID3Presenter;
import com.candor.sp.client.treegenerator.JsonTreeViewer;
import com.candor.sp.client.view.ID3View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.vaadin.VaadinComboBoxElement;
import elemental2.core.JsArray;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

/**
 * @author sp
 *
 */
public class ID3ViewImpl extends Composite implements ID3View {

    private static ID3ViewImplUiBinder uiBinder = GWT.create(ID3ViewImplUiBinder.class);
    @UiField
    protected HTMLElement treeElement;
    @UiField
    protected VaadinComboBoxElement id3type;


    private ID3Presenter presenter;

    /**
     * Because this class has a default constructor, it can be used as a binder template. In other
     * words, it can be used in other *.ui.xml files as follows:
     * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g=
     * "urn:import:**user's package**" > <g:**UserClassName**>Hello!</g:**UserClassName>
     * </ui:UiBinder> Note that depending on the widget that is used, it may be necessary to
     * implement HasHTML instead of HasText.
     */
    public ID3ViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));

        id3type.setAllowCustomValue(true);
        id3type.setItems(new JsArray<>("Information Gain", "Gain Ratio"));
        createTree("{\"name\":\"John\", \"age\":31, \"city\":\"New York\"}");

        this.getElement().appendChild(Polymer.createElement(VaadinComboBoxElement.TAG));
        initComponents();
    }

    private void initComponents() {

    }

    @Override
    public void setPresenter(ID3Presenter presenter) {
        this.presenter = presenter;
    }

    private void createTree(String tree){
        JSONObject root = (JSONObject) JSONParser.parseStrict(tree);
        this.getElement().getStyle().setOverflow(Style.Overflow.AUTO);

        TreeNode node = new TreeNode();
        treeElement.appendChild(Js.uncheckedCast(node.containerForOtherItems));
        JsonTreeViewer.createTree(node, root);
    }

    interface ID3ViewImplUiBinder extends UiBinder<HTMLPanel, ID3ViewImpl> {
    }

}
