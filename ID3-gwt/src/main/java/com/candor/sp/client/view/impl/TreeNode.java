package com.candor.sp.client.view.impl;

import com.candor.sp.client.jsi.JQuery;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import elemental2.dom.HTMLElement;

public class TreeNode extends Composite {

    private static final TreeNodeUiBinder uiBinder = GWT.create(TreeNodeUiBinder.class);

    @UiField
    protected HTMLElement itemName;
    @UiField
    protected HTMLElement expand;
    @UiField
    protected HTMLElement itemType;
    @UiField
    protected HTMLElement containerForOtherItems;

    public TreeNode() {
        initWidget(uiBinder.createAndBindUi(this));

        expand.addEventListener("click", evt -> {
            JQuery.$(containerForOtherItems).slideToggle(300, "swing");
            Element el = JQuery.$(this.getElement()).find(" > span").get(0);
            if (el.getClassName().contains("idf-expand-active")) {
                el.removeClassName("idf-expand-active");
            } else
                el.addClassName("idf-expand-active");
        });
    }



    public HTMLElement getItemName() {
        return itemName;
    }

    public void setItemName(HTMLElement itemName) {
        this.itemName = itemName;
    }

    public HTMLElement getExpand() {
        return expand;
    }

    public void setExpand(HTMLElement expand) {
        this.expand = expand;
    }

    public HTMLElement getItemType() {
        return itemType;
    }

    public void setItemType(HTMLElement itemType) {
        this.itemType = itemType;
    }

    public HTMLElement getContainerForOtherItems() {
        return containerForOtherItems;
    }

    interface TreeNodeUiBinder extends UiBinder<Widget, TreeNode> {
    }

}
