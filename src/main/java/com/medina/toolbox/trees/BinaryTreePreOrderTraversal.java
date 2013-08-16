package com.medina.toolbox.trees;

public class BinaryTreePreOrderTraversal {

	/* PRE ORDER TRAVERSAL:
	 * 
	 * 	ROOT --> LEFT CHILD --> RIGHT CHILD
	 */
	
	public static void traverse(BinaryTreeNode root) {
		
		if (root == null) {
			return;
		}
		
		System.out.printf("Node: %d\n",  root.data);
		traverse(root.leftChild);				
		traverse(root.rightChild);
		
		
	}

	public static void main(String[] args) {

		
		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		BinaryTreePreOrderTraversal.traverse(root);

	}

}
