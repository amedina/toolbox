package com.medina.toolbox.trees;

import java.util.ArrayList;

import com.medina.toolbox.arrays.UnionAndIntersectionSortedArrays;

public class BinaryTreeLowestCommonAncestor {

	/*
	 * SOLUTION #1: 
	 * 
	 * KEY IDA: Intersection of ancestry arrays 
	 */
	public static void lowestCommonAncestor(BinaryTreeNode root, int d1, int d2) {
	
		BinaryTreeNode t1 = BinarySearchTreeLookup.lookup(root, d1);
		BinaryTreeNode t2 = BinarySearchTreeLookup.lookup(root, d2);
		
		ArrayList<BinaryTreeNode> ancestors1 = new ArrayList<BinaryTreeNode>();
		ArrayList<BinaryTreeNode> ancestors2 = new ArrayList<BinaryTreeNode>();		
		BinaryTreeInOrderTraversal.getInOrderNodes(root, t1, ancestors1);
		BinaryTreeInOrderTraversal.getInOrderNodes(root, t2, ancestors2);
		
		ArrayList<BinaryTreeNode> intersection = UnionAndIntersectionSortedArrays.intersection(ancestors1, ancestors2);
		
		if (intersection.size() > 0) {
			System.out.println("LCA: " + intersection.get(intersection.size() - 1).data);
		}else {
			System.out.println("No LCA!");
		}
		
	}
	
	/*
	 * KEY IDEA: Use the BST property to determine the location of the LCA
	 */
	
	public static void lowestCommonAncestorTwo(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) throws IllegalArgumentException {
		
		if (root == null) {
			throw new IllegalArgumentException();
		}
		
		/* Make sure node1 < node2 (to make things easier) */
		if (node1.data > node2.data) {
			BinaryTreeNode t = node1;
			node1 = node2;
			node2 = t;
		}
		
		/* 
		 * CASE #1: node1 is on the LEFT SUBTREE and node2 is on the RIGHT SUBTREE;
		 * therefore, root is LCS. 
		 */
		if (root.data >= node1.data && root.data < node2.data) {
			System.out.println("LCA-2: " + root.data);
			return;
		}
		
		/*
		 * CASE #2: both nodes are on the LEFT SUBTREE
		 */
		if (root.data >= node1.data && root.data >= node2.data) {
			lowestCommonAncestorTwo(root.leftChild, node1, node2);
		}
		
		/*
		 * CASE #3: both nodes are on the RIGHT SUBTREE
		 */
		if (root.data < node1.data && root.data < node2.data) {
			lowestCommonAncestorTwo(root.rightChild, node1, node2);
		}

	}
	
	public static void lowestCommonAncestorTwo(BinaryTreeNode root, int d1, int d2) throws IllegalArgumentException {
		
		if (root == null) {
			throw new IllegalArgumentException();
		}
		
		if (d1 > d2) {
			int t = d1;
			d1 = d2;
			d2 = t;
		}
		
		if (root.data >= d1 && root.data < d2) {
			System.out.println("LCA-2: " + root.data);
			return;
		}
		
		if (root.data >= d1 && root.data >= d2) {
			lowestCommonAncestorTwo(root.leftChild, d1, d2);
		}
		
		if (root.data < d1 && root.data < d2) {
			lowestCommonAncestorTwo(root.rightChild, d1, d2);
		}
				
	}
	
	
	public static void lowestCommonAncestorTwoIterative(BinaryTreeNode root, int d1, int d2) throws IllegalArgumentException {
		
		if (d1 > d2) {
			int t = d1;
			d1 = d2;
			d2 = t;
		}
		
		while (root != null) {
			
			if (root.data >= d1 && root.data < d2) {
				System.out.println("LCA-2: " + root.data);
				return;
			}
			
			if (root.data >= d1 && root.data >= d2) {
				root = root.leftChild;
			}else {
				root = root.rightChild;
			}
			
		}
		
		System.out.println("LCA-2: NO LCA!");
			
	}
	

	public static void main(String[] args) {
	
		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		
		ArrayList<BinaryTreeNode> seq = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(root, seq);
//		for (int i = 0; i < seq.size(); i++) {					
//			System.out.printf("N[%d]: %d\n", i, seq.get(i).data);
//		}

		BinaryTreeLowestCommonAncestor.lowestCommonAncestor(root, seq.get(4).data, seq.get(8).data);
		BinaryTreeLowestCommonAncestor.lowestCommonAncestor(root, seq.get(8).data, seq.get(10).data);
		BinaryTreeLowestCommonAncestor.lowestCommonAncestor(root, seq.get(0).data, seq.get(5).data);
		
		BinaryTreeLowestCommonAncestor.lowestCommonAncestorTwo(root, seq.get(4), seq.get(8));
		BinaryTreeLowestCommonAncestor.lowestCommonAncestorTwo(root, seq.get(8), seq.get(10));
		BinaryTreeLowestCommonAncestor.lowestCommonAncestorTwo(root, seq.get(0), seq.get(5));

	}

}
