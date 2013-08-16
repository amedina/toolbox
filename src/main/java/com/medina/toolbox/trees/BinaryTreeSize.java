package com.medina.toolbox.trees;

public class BinaryTreeSize {


	public static int size(BinaryTreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		int leftSize = size(root.leftChild);
		int rightSize = size(root.rightChild);
		
		return 1 + leftSize + rightSize;
		
	}
	
	
	public static void main(String[] args) {
	
		

	}

}
