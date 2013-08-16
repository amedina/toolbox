package com.medina.toolbox.trees;

public class BinaryTreeHasPathSum {

	/*
	 * KEY IDEA: subtract value of current node from parameter sum, and
	 * recursively check each sub path from the children
	 */
	public boolean hasPathSum(BinaryTreeNode root, int sum) {
	
		if (root == null) {
			return false;
		}
		
		if (root.data == sum && root.leftChild == null && root.rightChild == null) {
			return true;
		}
		
		boolean hasLeftPathSum = hasPathSum(root.leftChild, sum - root.data);
		boolean hasRightPathSum = hasPathSum(root.rightChild, sum - root.data);
				
		return hasLeftPathSum || hasRightPathSum;
		
	}
	
	
	public static void main(String[] args) {

	}

}
