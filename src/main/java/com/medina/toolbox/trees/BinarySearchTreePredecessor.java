package com.medina.toolbox.trees;

import java.util.ArrayList;

public class BinarySearchTreePredecessor {
	
	/*
	 * KEY IDEA:
	 * 
	 * (1) The PREDECESSOR of a node WITH LEFT CHILD is the MAX VALUE in its
	 * LEFT SUBTREE
	 * 
	 * (2) If the node HAS NO LEFT CHILD, then TRAVERSE the tree UP STREAM via the
	 * PARENT POINTERS; KEEP TRAVERSING UNTIL (a) the current node IS NOT the
	 * left child of the current parent, OR, the current parent is NULL
	 */

	public static int predecessor(BinaryTreeNode node) throws IllegalArgumentException {
		
		if (node == null) {
			throw new IllegalArgumentException();
		}
 		
		/* CASE #1: Return max value in LEFT SUBTREE */
		if (node.leftChild != null) {
			return BinaryTreeMax.maxValueRecursive(node.leftChild);
		}
		
		/* CASE #2: TRAVERSE TREE UPSTREAM */
		BinaryTreeNode p = node.parent;		
		while (p != null && node == p.leftChild) {
			node = p;
			p = node.parent;
		}
		
		if (p != null) {
			return p.data;
		}else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {

		int[] b = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(b);
		
		ArrayList<BinaryTreeNode> seq = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(root, seq);
		
		for (int i = 0; i < seq.size(); i++) {			
			int pred = BinarySearchTreePredecessor.predecessor(seq.get(i));
			System.out.printf("N[%d]: %d PRED: %d\n", i, seq.get(i).data, pred);
		}		
		
	}

}
