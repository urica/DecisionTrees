package com.candor.sp.server.implementation;

import com.google.gwt.junit.client.GWTTestCase;

public class PrintTreeTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return null;
    }

    /**
     * Test Leaf node
     */
    public void testLeafNode() {
        PrintTree pt = new PrintTree();

        TreeNode tn = new TreeNode("Y");
        String json = "{\"Leaf\":\"Y\"}";

        assertTrue(pt.getJSON(tn).equals(json));
    }

}
