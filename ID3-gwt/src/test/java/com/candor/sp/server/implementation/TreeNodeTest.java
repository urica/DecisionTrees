package com.candor.sp.server.implementation;

import com.google.gwt.junit.client.GWTTestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeNodeTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return null;
    }

    /**
     * Test Leaf node
     */
    public void testLeafNode() {
        TreeNode tn = new TreeNode("Y");
        assertTrue(tn.getTargetLabel().equals("Y"));
        assertTrue(tn.toString().equals("Leaf label: Y"));
        assertTrue(tn.getType().equals("leaf"));
    }

    /**
     * Test Root node without children
     */
    public void testRootNode() {
        String name = "Hobbies";
        List<String> values = new ArrayList<>();
        values.add("Swimming");
        values.add("Claiming");
        values.add("Football");

        Attribute attr = new Attribute(name, values);

        TreeNode tn = new TreeNode(attr);

        assertTrue(tn.getAttribute().getName().equals(name));
        assertTrue(tn.getAttribute().getValues().containsAll(values));
        assertTrue(tn.getAttribute().getValues().contains("Football"));

        //Changing Attr values
        List<String> values2 = new ArrayList<>();
        values2.add("Running");
        values2.add("Eating");
        values2.add("Gaming");

        tn.getAttribute().setValues(values2);

        assertTrue(tn.getAttribute().getName().equals(name));
        assertTrue(tn.getAttribute().getValues().containsAll(values2));
        assertTrue(tn.getAttribute().getValues().contains("Eating"));

        assertTrue(tn.getType().equals("root"));

        assertTrue(tn.getAttribute().toString().equals("@Attribute Name: " + name + "; @Attribute Values: " + values2));
    }

    /**
     * Test Root node with children
     */
    public void testRootNodeWithChildren() {
        String name = "Hobbies";
        List<String> values = new ArrayList<>();
        values.add("Swimming");
        values.add("Claiming");
        values.add("Football");

        Attribute attr = new Attribute(name, values);

        TreeNode tn = new TreeNode(attr);

        HashMap<String, TreeNode> children = new HashMap<>();
        children.put("node1", tn);

        TreeNode myNode = new TreeNode(attr);
        myNode.addChild("node1", tn);

        assertTrue(myNode.getChildren().containsKey("node1"));

    }

}
