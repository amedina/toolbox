package com.medina.toolbox.trees;


public class BinaryTreePrintPaths {

	private static void printPath(int[] path, int pathLength) {
		
		for (int i = 0; i < pathLength; i++) {
			System.out.printf("%d ", path[i]);
		}
		System.out.println("");
	}
	
	private static void printPaths(BinaryTreeNode node, int[] path, int pathLength) {
		
		/* BASE CASE: Call on a null BT */
		if (node == null) {return;}
		
		/* (1) Add current root to path */
		path[pathLength] = node.data;
		pathLength++;
		
		printPaths(node.leftChild, path, pathLength);
		printPaths(node.rightChild, path, pathLength);
		
		if (node.leftChild == null && node.rightChild == null) {
			printPath(path, pathLength);
		}
		
	}

	
	public static void main(String[] args) {
	
		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		int[] p = new int[100];
		BinaryTreePrintPaths.printPaths(root, p, 0);
		
	}

}
