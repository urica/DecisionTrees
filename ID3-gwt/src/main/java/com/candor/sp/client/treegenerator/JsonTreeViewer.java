package com.candor.sp.client.treegenerator;

import com.candor.sp.client.view.impl.TreeNode;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import jsinterop.base.Js;

import java.util.Set;

public class JsonTreeViewer {

    public static void createTree(TreeNode tn, JSONObject json) {
        createObject(tn, json, "$");
    }

    private static void createObject(TreeNode parent, Object data, String path) {
        if (data instanceof JSONObject) {
            createJSONObject(parent, (JSONObject) data, path);
        } else if (data instanceof JSONArray) {
            createJSONArray(parent, (JSONArray) data, path);
        } else {
            createPrimitive(parent, data, path);
        }
    }

    private static void createJSONObject(TreeNode parent, JSONObject json, String path) {
        Set<String> it = json.keySet();
        it.forEach(k -> {
            if (json.get(k).getClass().equals(JSONObject.class) || json.get(k).getClass().equals(JSONArray.class)) {
                TreeNode node = new TreeNode();
                String s = node.getItemName().innerHTML;
                node.getItemName().innerHTML = s + " " + k;
                node.getItemType().classList.add("idf-object");
                String childKey = path.isEmpty() ? k : path + "." + k;
                node.getItemName().setAttribute("path", childKey);
                node.getItemName().setAttribute("targetPath", childKey);
                node.getExpand().classList.add("idf-expand-active");
                node.getContainerForOtherItems().style.display = "block";
                parent.getContainerForOtherItems().appendChild(Js.uncheckedCast(node.getElement()));

                Object child = json.get(k);
                createObject(node, child, childKey);
            } else {
                String isArrayIndexObj = path.replace(path.substring(0, path.lastIndexOf(".") + 1), "");
                int isArrayIndexObjInt = -1;
                try {
                    isArrayIndexObjInt = Integer.parseInt(isArrayIndexObj);
                } catch (Exception ex) {
                }
                TreeNode objNode = new TreeNode();
                objNode.getExpand().classList.add("idf-hidden");
                String childKey = path.isEmpty() ? k : path + "." + k;
                objNode.getItemName().setAttribute("path", childKey);
                if (isArrayIndexObjInt > -1) {
                    objNode.getItemName().setAttribute("targetPath", "$." + k);
                } else {
                    objNode.getItemName().setAttribute("targetPath", childKey);
                }
                objNode.getItemName().innerHTML = objNode.getItemName().innerHTML + k + ": <b>" + json.get(k).toString().replace("\"", "");
                parent.getContainerForOtherItems().appendChild(Js.uncheckedCast(objNode.getElement()));
            }
        });
    }

    private static void createJSONArray(TreeNode parent, JSONArray json, String path) {
        int i = 0;
        Object data = json.get(i);
        parent.getItemType().classList.remove("idf-object");
        parent.getItemType().classList.add("idf-array");
        if (data.getClass().equals(JSONObject.class) || data.getClass().equals(JSONArray.class)) {
            TreeNode node = new TreeNode();
            String s = node.getItemName().innerHTML;
            node.getItemName().innerHTML = s + " " + i;
            node.getExpand().classList.add("idf-expand-active");
            node.getContainerForOtherItems().style.display = "block";
            node.getItemType().classList.add("idf-object");
            String str = path + "." + i;
            node.getItemName().setAttribute("path", str);
            node.getItemName().setAttribute("targetPath", str);
            parent.getContainerForOtherItems().appendChild(Js.uncheckedCast(node.getElement()));
            createObject(node, data, str);
        } else {
            TreeNode n = new TreeNode();
            n.getItemName().innerHTML = n.getItemName().innerHTML + " " + i + ": <b>" + data.toString().replace("\"", "");
            n.getExpand().classList.add("idf-hidden");
            String str = path + "." + i;
            n.getItemName().setAttribute("path", str);
            n.getItemName().setAttribute("targetPath", str);
            parent.getContainerForOtherItems().appendChild(Js.uncheckedCast(n.getElement()));
        }
    }

    private static void createPrimitive(TreeNode parent, Object obj, String path) {
        TreeNode node = new TreeNode();
        String s = node.getItemName().innerHTML;
        node.getItemName().setAttribute("path", path);
        node.getItemName().setAttribute("targetPath", path);
        node.getItemName().innerHTML = s + obj.toString().replace("\"", "");
        node.getExpand().classList.add("idf-hidden");
        parent.getContainerForOtherItems().appendChild(Js.uncheckedCast(node.getElement()));
    }

}
