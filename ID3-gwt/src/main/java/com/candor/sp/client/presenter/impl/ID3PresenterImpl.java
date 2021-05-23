/**
 *
 */
package com.candor.sp.client.presenter.impl;

import com.candor.sp.client.presenter.ID3Presenter;
import com.candor.sp.client.presenter.Presenter;
import com.candor.sp.client.rpc.RpcService;
import com.candor.sp.client.rpc.RpcServiceAsync;
import com.candor.sp.client.util.ClientUtils;
import com.candor.sp.client.view.ID3View;
import com.candor.sp.shared.DataFraud;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.vaadin.VaadinComboBoxElement;
import elemental2.core.JsArray;
import elemental2.dom.CSSProperties;

import java.util.List;
import java.util.Optional;

/**
 * @author sp
 *
 */
public class ID3PresenterImpl implements ID3Presenter {

    private final ID3View view;
    private final RpcServiceAsync rpcService = GWT.create(RpcService.class);

    @Inject
    public ID3PresenterImpl(ID3View view) {
        this.view = view;
        bind();
    }

    /**
     *
     * @see Presenter#go(com.google.gwt.user.client.ui.HasOneWidget)
     */
    @Override
    public void go(HasOneWidget container) {
        container.setWidget(view.asWidget());
    }

    /**
     *
     * @see Presenter#bind()
     */
    @Override
    public void bind() {
        view.setPresenter(this);
    }

    private DialogBox showCustomDialog(String str) {
        final DialogBox dialog = new DialogBox(false, true);
        dialog.setText("Prediction");
        dialog.getElement().getStyle().setZIndex(1);
        // Setcontent
        Label content = new Label(str);
        if (dialog.isAutoHideEnabled()) {
            dialog.setWidget(content);
        } else {
            VerticalPanel vPanel = new VerticalPanel();
            vPanel.setSpacing(2);
            vPanel.add(content);
            vPanel.add(new Label("\n"));
            vPanel.add(new Button("Close", new ClickHandler() {
                public void onClick(ClickEvent event) {
                    dialog.hide();
                }
            }));
            dialog.setWidget(vPanel);
        }
        dialog.setPopupPosition(100, 150);
        dialog.show();
        return dialog;
    }

    @Override
    public void onCreateTable(String gainType) {
        rpcService.myMethod(gainType, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("FAILD");
            }

            @Override
            public void onSuccess(String s) {
                ClientUtils.showNotification("Decision tree sucessfully created!");
                view.createTree(s);
                getAllColumnNames();
            }
        });
    }

    @Override
    public void getAllColumnNames() {

        rpcService.getAllColumnNames(new AsyncCallback<List<String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("getAllColumnNames - FAILD");
            }

            @Override
            public void onSuccess(List<String> s) {
                s.stream().forEach(el -> {
                    VaadinComboBoxElement combobox = Polymer.createElement(VaadinComboBoxElement.TAG);
                    combobox.setName(el);
                    combobox.setLabel(el);
                    combobox.style.width = CSSProperties.WidthUnionType.of("20%");
                    combobox.style.margin = CSSProperties.MarginUnionType.of("2%");

                    getAllValuesForColumn(el, combobox);
                    Optional.ofNullable(el).ifPresent(items -> {
                        getAllValuesForColumn(items, combobox);
                        view.getFields().appendChild(combobox);
                    });
                });
            }
        });
    }

    private void getAllValuesForColumn(String column, VaadinComboBoxElement comboBoxElement) {
        rpcService.getAttrValuesByColumn(column, new AsyncCallback<List<String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("getAllValues - FAILD");
            }

            @Override
            public void onSuccess(List<String> s) {
                comboBoxElement.setItems(new JsArray<>(s.toArray()));
            }
        });
    }

    @Override
    public void getAllValues(String column) {
        rpcService.getAttrValuesByColumn(column, new AsyncCallback<List<String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("getAllValues - FAILD");
            }

            @Override
            public void onSuccess(List<String> s) {
            }
        });
    }

    @Override
    public void testData(DataFraud dataFraud) {
        rpcService.testData(dataFraud, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("getAllValues - FAILD");
            }

            @Override
            public void onSuccess(String s) {
                String yes = "Based on DT this data's points to a fraud, please take care!";
                String no = "Based on DT this data's does not points to a fraud!";
                showCustomDialog(s.equals("Y") ? yes : no).show();
            }
        });

    }

    @Override
    public void showPopup(String message) {
        showCustomDialog(message).show();
    }

}
