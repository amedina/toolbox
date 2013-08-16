package com.medina.toolbox.trees;

import java.util.ArrayList;

/*
 * Problem: Given a BST as input, verify that its structure
 * satisfies the BST property 
 */
public class BinaryTreeCheckBST {
	
	/* Solution #1:
	 *  
	 * (1) Perform an IN-ORDER TRAVERSAL of the tree
	 * (2) Collect the nodes from the traversal into an array
	 * (3) Scan the array checking that it is MONOTONICALLY INCREASING
	 * 
	 */
	
	public static boolean isBSTOne(BinaryTreeNode root) {
	
		if (root == null) {
			return true;
		}
		
		ArrayList<Integer> seq = new ArrayList<Integer>();
		BinaryTreeInOrderTraversal.getInOrderSequence(root, seq);
		
		for (int i = 1; i < seq.size(); i++) {
			if (seq.get(i - 1) > seq.get(i)) {
				return false;
			}
		}
		
		return true;
		
	}
	
	/* Solution #2:
	 * 
	 * (1) Check that root.data >= minValue(root.leftChild)
	 * (2) Check that root.data < maxValue(root.rightChild)
	 * (3) Check isBST(root.leftChild) && isBST(root.rightChild);
	 * 
	 * Issue: the MIN and MAX values are computed too many times
	 */
	
	public static boolean isBSTTwo(BinaryTreeNode root) {
		
		if (root == null) {
			return true;
		}
		
		if (root.leftChild != null) {

			int leftMinValue = BinaryTreeMin.minValueRecursive(root.leftChild);

			if (root.data < leftMinValue) {
				return false;
			}
		}
		
		if (root.rightChild != null) {
			
			int rightMaxValue = BinaryTreeMax.maxValueRecursive(root.rightChild);
			
			if (root.data >= rightMaxValue) {
				return false;
			}
		}
		
		return isBSTTwo(root.leftChild) && isBSTTwo(root.rightChild);
		
	}
	
	
	/*
	 * Solution #3: Similar idea as solution #2, but more efficient w.r.t the
	 * computation of the MIN and MAX values (compute them once)
	 */
	public static boolean isBSTThree(BinaryTreeNode root) {
		
		/* Compute overall MIN and MX values for the whole tree */
		int min = BinaryTreeMin.minValueRecursive(root);
		int max = BinaryTreeMax.maxValueRecursive(root);
			
		return isBSTThreeAux(root, min, max);
		
	}
	
	public static boolean isBSTThreeAux(BinaryTreeNode root, int min, int max) {
		
		if (root == null) {
			return true;
		}
		
		if ((root.data < min) || (root.data >= max)) {
				return false;
		}
		
		return isBSTThreeAux(root.leftChild, min, max) && isBSTThreeAux(root.rightChild, min, max);
		
	}
	
	public static void main(String[] args) {
		
		int[] b = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(b);
		BinaryTreePrintLevelOrder.printLevelOrder(root);
		
		ArrayList<BinaryTreeNode> seq = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(root, seq);
		for (int i = 0; i < seq.size(); i++) {					
			System.out.printf("N[%d]: %d\n", i, seq.get(i).data);
		}
		boolean isBST = BinaryTreeCheckBST.isBSTOne(root);
		System.out.printf("BEFORE isBST (ONE): %s\n", isBST);
		isBST = BinaryTreeCheckBST.isBSTTwo(root);
		System.out.printf("BEFORE isBST (TWO): %s\n", isBST);
		isBST = BinaryTreeCheckBST.isBSTThree(root);
		System.out.printf("BEFORE isBST (THREE): %s\n", isBST);
		
		/*  Screw it */
		seq.get(4).data = 16; 
		
		isBST = BinaryTreeCheckBST.isBSTOne(root);
		System.out.printf("AFTER isBST (ONE): %s\n", isBST);
		isBST = BinaryTreeCheckBST.isBSTTwo(root);
		System.out.printf("AFTER isBST (TWO): %s\n", isBST);
		isBST = BinaryTreeCheckBST.isBSTThree(root);
		System.out.printf("AFTER isBST (THREE): %s\n", isBST);
		
	}

}
