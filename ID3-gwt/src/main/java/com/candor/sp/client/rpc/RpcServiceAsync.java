package com.candor.sp.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RpcServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.candor.sp.client.rpc.RpcService
     */
    void createTree( java.lang.String s, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.candor.sp.client.rpc.RpcService
     */
    void getAllColumnNames( AsyncCallback<java.util.List<java.lang.String>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.candor.sp.client.rpc.RpcService
     */
    void getAttrValuesByColumn( java.lang.String column, AsyncCallback<java.util.List<java.lang.String>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.candor.sp.client.rpc.RpcService
     */
    void testData( com.candor.sp.shared.DataFraud data, AsyncCallback<java.lang.String> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static RpcServiceAsync instance;

        public static final RpcServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (RpcServiceAsync) GWT.create( RpcService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
