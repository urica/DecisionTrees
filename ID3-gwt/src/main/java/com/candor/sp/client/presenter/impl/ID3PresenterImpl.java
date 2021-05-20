/**
 *
 */
package com.candor.sp.client.presenter.impl;

import com.candor.sp.client.presenter.ID3Presenter;
import com.candor.sp.client.presenter.Presenter;
import com.candor.sp.client.rpc.RpcService;
import com.candor.sp.client.rpc.RpcServiceAsync;
import com.candor.sp.client.view.ID3View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.inject.Inject;

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

        addEventBusHandlers();
    }

    @Override
    public void onCreateTable(String gainType){
        rpcService.myMethod(gainType, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("FAILD");
            }

            @Override
            public void onSuccess(String s) {
                view.createTree(s);
            }
        });
    }

    /**
     * Register handlers on the BUS
     */
    private void addEventBusHandlers() {

//		AppGinjector.INSTANCE.getEventBus().addHandlerToSource(SelectPlaceEvent.TYPE, PredictionsCellList.class, event -> {
//			History.newItem(Token.PLACES + "?cityid=" + event.getPlaceId());
//		});

    }

}
