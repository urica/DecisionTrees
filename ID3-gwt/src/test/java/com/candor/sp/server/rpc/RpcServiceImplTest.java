package com.candor.sp.server.rpc;

import com.candor.sp.shared.DataFraud;
import com.candor.sp.shared.GainType;
import com.google.gwt.junit.client.GWTTestCase;

public class RpcServiceImplTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return null;
    }

    public void testRpcService(){
        RpcServiceImpl rpc = new RpcServiceImpl();
        rpc.createTree(GainType.GAIN_RATIO.getValue());
        rpc.getAllColumnNames();
        rpc.getAttrValuesByColumn("Age");

        DataFraud tf = new DataFraud();
        rpc.testData(tf);
    }
}
