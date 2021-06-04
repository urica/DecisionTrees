package com.candor.sp.server.implementation; /*********************************
 * This class defines TreeNode type of the decision tree,
 * including two types node, root and leaf.
 *********************************/

import java.util.HashMap;

public class TreeNode {
	private String type;
	private Attribute attribute;
	private HashMap<String, TreeNode> children;
	private String targetLabel;
	
	public TreeNode(Attribute attribute) {
		type = "root";
		this.attribute = attribute;
		children = new HashMap<String, TreeNode>();
	}
	
	public TreeNode(String targetLabel) {
		type = "leaf";
		this.targetLabel = targetLabel;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	
	public void addChild(String valueName, TreeNode child) {
		children.put(valueName, child);
	}
	public HashMap<String, TreeNode> getChildren() {
		return children;
	}
	
	public String getTargetLabel() {
		return targetLabel;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		if (type.equals("root")) return "Root attribute: " + attribute.getName() + "; Children: " + children;
		else return "Leaf label: " + targetLabel;
	}
}