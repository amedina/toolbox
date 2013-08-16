package com.medina.toolbox.trees;

public class BinaryTreePostOrderTraversal {

	
	/* POST ORDER TRAVERSAL:
	 * 
	 * 	LEFT CHILD --> RIGHT CHILD --> ROOT
	 */
	public static void traverse(BinaryTreeNode root) {
		
		if (root == null) {
			return;
		}
		
		traverse(root.leftChild);				
		traverse(root.rightChild);
		System.out.printf("Node: %d\n ", root.data);
		
	}

	public static void main(String[] args) {

		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		BinaryTreePostOrderTraversal.traverse(root);

	}

}
