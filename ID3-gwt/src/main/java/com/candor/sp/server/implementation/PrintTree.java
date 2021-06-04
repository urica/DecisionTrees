package com.candor.sp.server.implementation;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintTree {

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

}