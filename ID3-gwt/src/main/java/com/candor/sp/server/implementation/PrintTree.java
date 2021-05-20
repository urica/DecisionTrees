package com.candor.sp.server.implementation;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintTree {
    private String pic;

    /**
     * This method print out each path of the tree from root to leaf.
     *
     * @param root
     * @return ArrayList<String>
     */
    public ArrayList<String> printDFS(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        printDFS(root, new StringBuilder(), res);
        return res;
    }

    private void printDFS(TreeNode root, StringBuilder sb, ArrayList<String> res) {
        if (root.getType().equals("leaf")) {
            StringBuilder curr = new StringBuilder(sb);
            curr.append(root.getTargetLabel());
            curr.append("\n");
            res.add(curr.toString());
        } else {
            sb.append(root.getAttribute().getName());
            HashMap<String, TreeNode> children = root.getChildren();
            for (String valueName : children.keySet()) {
                StringBuilder curr = new StringBuilder(sb);
                curr.append("(");
                curr.append(valueName);
                curr.append(")");
                printDFS(children.get(valueName), curr, res);
            }
        }
    }

    public String getJSON(TreeNode root) {
        JsonObject jsonRoot = new JsonObject();
        ArrayList<JsonObject> res = new ArrayList<>();
        getJSON(root, jsonRoot, res);

        JsonObject myStuff = new JsonObject();
        res.forEach(el->{
            myStuff.add("ROOT",el);
        });
//        System.out.println("JSON: " + myStuff.toString());
        return jsonRoot.toString();
    }

    private void getJSON(TreeNode root, JsonObject sb, ArrayList<JsonObject> res) {
        if (root.getType().equals("leaf")) {
            sb.add("Leaf", new JsonPrimitive(root.getTargetLabel()));
            res.add(sb);
        } else {
            HashMap<String, TreeNode> children = root.getChildren();
            JsonObject obj = new JsonObject();
            sb.add(root.getAttribute().getName(), obj);
            for (String valueName : children.keySet()) {
                JsonObject objval = new JsonObject();
                obj.add(valueName, objval);
                getJSON(children.get(valueName), objval, res);
            }
        }
    }

    @Override
    public String toString() {
        return pic;
    }
}