package com.medina.toolbox.trees;

import java.util.ArrayList;

public class BinarySearchTreeSuccessor {

	/*
	 * KEY IDEA:
	 * 
	 * (1) The SUCCESOR of a node WITH A RIGHT CHILD is the MIN VALUE in its
	 * RIGHT SUBTREE
	 * 
	 * (2) If the node HAS NO RIGHT CHILD, then TRAVERSE the tree UP vis the
	 * PARENT POINTERS; KEEP TRAVERSING UNTIL (a) the current node is not the
	 * RIGHT CHILD of the current parent, OR, the current parent is NULL
	 */

	
	public static int successor(BinaryTreeNode node) throws IllegalArgumentException {
		
		if (node == null) {
			throw new IllegalArgumentException();
		}
 		
		/* CASE #1: node HAS A RIGHT CHILD */
		if (node.rightChild != null) {
			return BinaryTreeMin.minValueRecursive(node.rightChild);
		}
		
		/* CASE #2: TRAVER TREE UPSTREAM */
		BinaryTreeNode p = node.parent;		
		while (p != null && node == p.rightChild) {
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
			int pred = BinarySearchTreeSuccessor.successor(seq.get(i));
			System.out.printf("N[%d]: %d SUCC: %d\n", i, seq.get(i).data, pred);
		}		
	
	}

}
