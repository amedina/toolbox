package com.medina.toolbox.trees;

public class BinaryTreeMaxDepth {

	public static int maxDepth(BinaryTreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		int leftMaxDepth = maxDepth(root.leftChild);
		int rightMaxDepth = maxDepth(root.rightChild);
		
		return 1 + Math.max(leftMaxDepth, rightMaxDepth);
	}

	public static void main(String[] args) {


	}

}
