package com.candor.sp.server.rpc;

import com.candor.sp.client.rpc.RpcService;
import com.candor.sp.server.implementation.ID3;
import com.candor.sp.shared.DataFraud;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.IOException;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 *
 * @author sp
 */
@SuppressWarnings("serial")
public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
    private ID3 id3 = new ID3();

    @Override
    public String myMethod(String s) {
        try {
            return id3.createTree(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<String> getAllColumnNames() {
        return id3.getAllColumnsName();
    }

    @Override
    public List<String> getAttrValuesByColumn(String column) {
        return id3.getAttrValues(column);
    }

    public String testData(DataFraud data) {
        return id3.testData(data);
    }

    ;
}
