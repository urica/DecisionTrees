package com.candor.sp.server.rpc;

import com.candor.sp.client.rpc.RpcService;
import com.candor.sp.server.implementation.ID3;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.IOException;

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
        ID3 id3 = new ID3();
        System.out.println("gainType = " + s);
        try {
            return id3.createTree(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "MyString";
    }
}
