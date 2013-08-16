package com.medina.toolbox.trees;

import java.util.ArrayList;

public class BinaryTreeEquality {

	private boolean sameTree(BinaryTreeNode a, BinaryTreeNode b) {
		
		if (a == null && b == null) {return true;}
		if (a != null && b != null) {			
			if (a.data == b.data) {
				boolean lst = sameTree(a.leftChild, b.leftChild);
				boolean rst = sameTree(a.rightChild, b.rightChild);
				return lst && rst;
			}			
		}
		
		return false;
	}

	public static boolean equal(BinaryTreeNode t1, BinaryTreeNode t2) {
		
		if (t1 == null && t2 == null) {
			return true;
		}
		
		if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
			return false;
		}
		
		if (t1.data != t2.data){
			return false;
		}
		
		boolean leftAreEqual = equal(t1.leftChild, t2.leftChild);
		boolean rightAreEqual = equal(t1.rightChild, t2.rightChild);
		
		return leftAreEqual && rightAreEqual;
		
	}	
	
	public static void main(String[] args) {

		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode rootA = BinarySearchTreeBuild.build(a);
		
		int[] b = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode rootB = BinarySearchTreeBuild.build(b);
		
		boolean areEqual = BinaryTreeEquality.equal(rootA,  rootB);
		System.out.printf("BEFORE areEqual: %s\n", areEqual);
		
		ArrayList<BinaryTreeNode> seq = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(rootA, seq);
		/*  Screw it */
		seq.get(4).data = 16; 
		
		areEqual = BinaryTreeEquality.equal(rootA,  rootB);
		System.out.printf("AFTER areEqual: %s\n", areEqual);
	}

}
