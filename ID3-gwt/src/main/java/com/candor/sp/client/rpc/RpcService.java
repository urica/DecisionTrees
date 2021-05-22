package com.candor.sp.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * The client side stub for the RPC service.
 * 
 * @author sp
 *
 */
@RemoteServiceRelativePath("rpc")
public interface RpcService extends RemoteService {
    public String myMethod(String s);

    public List<String> getAllColumnNames();
}
