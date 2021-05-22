package com.candor.sp.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface RpcServiceAsync
{

    public void myMethod(String s, AsyncCallback<String> callback);

    public List<String> getAllColumnNames(AsyncCallback<List<String>> callback);

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
