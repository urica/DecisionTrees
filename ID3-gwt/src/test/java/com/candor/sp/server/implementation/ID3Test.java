package com.candor.sp.server.implementation;

import com.candor.sp.server.preprocesing.PreprocesingDataSet;
import com.candor.sp.shared.GainType;
import com.google.gwt.junit.client.GWTTestCase;

import java.io.IOException;

public class ID3Test extends GWTTestCase {

    @Override
    public String getModuleName() {
        return null;
    }

    public void testCreateTree() throws IOException {
        ID3 id3 = new ID3();
        id3.createTree(GainType.GAIN_RATIO.getValue());
        id3.getAllColumnsName();
        id3.getAttrValues("Age");
    }

    public void testPreprocesing() throws IOException {
        PreprocesingDataSet preprocesingDataSet = new PreprocesingDataSet();

        PreprocesingDataSet.main(new String[0]);
    }
}
