/**
 *
 */
package com.candor.sp.client.view.impl;

import com.candor.sp.client.presenter.ID3Presenter;
import com.candor.sp.client.treegenerator.JsonTreeViewer;
import com.candor.sp.client.view.ID3View;
import com.candor.sp.shared.GainType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.PaperButtonElement;
import com.vaadin.polymer.vaadin.VaadinComboBoxElement;
import elemental2.core.JsArray;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    @UiField
    protected PaperButtonElement createTree;

    private ID3Presenter presenter;

    public ID3ViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        createTree("{\"name\":\"John\", \"age\":31, \"city\":\"New York\"}");

        initComponents();

        addEventHandlers();
    }

    private void addEventHandlers(){
        createTree.addEventListener("click", evt->{
            presenter.onCreateTable(Js.uncheckedCast(id3type.getSelectedItem()));
        });
    }

    private void initComponents() {
        id3type.setAllowCustomValue(true);
        id3type.setItems(new JsArray<>(Arrays.stream(GainType.values()).map(v->v.getValue()).collect(Collectors.toList()).toArray()));
    }

    @Override
    public void setPresenter(ID3Presenter presenter) {
        this.presenter = presenter;
    }

    public void createTree(String tree){
        clearTree();
        JSONObject root = (JSONObject) JSONParser.parseStrict(tree);
        this.getElement().getStyle().setOverflow(Style.Overflow.AUTO);

        TreeNode node = new TreeNode();
        treeElement.appendChild(Js.uncheckedCast(node.containerForOtherItems));
        JsonTreeViewer.createTree(node, root);
    }

    private void clearTree(){
        while (treeElement.firstChild != null) {
            treeElement.removeChild(treeElement.firstChild);
        }
    }

    interface ID3ViewImplUiBinder extends UiBinder<HTMLPanel, ID3ViewImpl> {
    }

}
