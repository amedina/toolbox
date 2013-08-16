package com.medina.toolbox.trees;

import java.util.ArrayList;

public class BinaryTreeDouble {

	/*
	 * For each node in a binary tree, create a new DUPLICATE node, and isnert
	 * it as the left child of the original node. The resulting tree should satisfy 
	 * the BST property
	 */
	public static void doubleTree(BinaryTreeNode root) {
	
		/* Base Case */
		if (root == null) {
			return;
		}
		
		/* RECURSIVE calls for LEFT and RIGHT children */
		doubleTree(root.leftChild);
		doubleTree(root.rightChild);
		
		/* Create New Node (double) */
		BinaryTreeNode newNode = new BinaryTreeNode(root.data); 
		
		newNode.leftChild = root.leftChild;
		root.leftChild = newNode;
		
	}
	
	public static void main(String[] args) {

		int[] b = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(b);
		
		ArrayList<BinaryTreeNode> seq = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(root, seq);
		for (int i = 0; i < seq.size(); i++) {					
			System.out.printf("N[%d]: %d\n", i, seq.get(i).data);
		}
		System.out.printf("=====================\n");
		
		BinaryTreeDouble.doubleTree(root);
		
		seq.clear();
		BinaryTreeInOrderTraversal.getInOrderNodes(root, seq);
		for (int i = 0; i < seq.size(); i++) {					
			System.out.printf("N[%d]: %d\n", i, seq.get(i).data);
		}
	}

}
