package com.medina.toolbox.trees;

public class BinarySearchTreeBuild {

	public static BinaryTreeNode build(int[] a) {
		
		BinaryTreeNode root = null;
		for (int i = 0; i < a.length; i++) {
			root = BinarySearchTreeInsert.insert(root, a[i]);
		}
		
		return root;
		
	}
	
	public static void main(String[] args) {

	}

}
