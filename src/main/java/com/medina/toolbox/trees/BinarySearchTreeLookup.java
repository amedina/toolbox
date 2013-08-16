package com.medina.toolbox.trees;

public class BinarySearchTreeLookup {

	public static BinaryTreeNode lookup(BinaryTreeNode root, int target) {
		
		if (root == null) {
			return null;
		}
		
		if (root.data == target) {
			return root;
		}
		
		if (root.data > target) {
			return lookup(root.leftChild, target);
		}else {
			return lookup(root.rightChild, target);
		}
		
	}
	
	public static void main(String[] args) {

		
		
	}

}
