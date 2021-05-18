package com.candor.sp.server.rpc;

import com.candor.sp.client.rpc.RpcService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 * 
 * @author sp
 *
 */
@SuppressWarnings("serial")
public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
    @Override
    public String myMethod(String s) {
        return "MyString";
    }
}
