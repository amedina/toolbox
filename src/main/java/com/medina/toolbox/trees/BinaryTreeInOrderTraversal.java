package com.medina.toolbox.trees;

import java.util.ArrayList;

public class BinaryTreeInOrderTraversal {

	public static void getInOrderNodes(BinaryTreeNode root, BinaryTreeNode target, ArrayList<BinaryTreeNode> seq) {

		if (root == null) {
			return;
		}
		
		if (root == target) {
			seq.add(root);
			return;
		}
		
		seq.add(root);
		if (root.data >= target.data) {
			getInOrderNodes(root.leftChild, target, seq);
		}else {
			getInOrderNodes(root.rightChild, target, seq);
		}		
	}
	
	public static void getInOrderSequence(BinaryTreeNode root, ArrayList<Integer> seq) {

		if (root == null) {
			return;
		}
		
		getInOrderSequence(root.leftChild, seq);		
		seq.add(root.data);
		getInOrderSequence(root.rightChild, seq);
		
	}

	public static void getInOrderNodes(BinaryTreeNode root, ArrayList<BinaryTreeNode> seq) {

		if (root == null) {
			return;
		}
		
		getInOrderNodes(root.leftChild, seq);		
		seq.add(root);
		getInOrderNodes(root.rightChild, seq);
		
	}
	
	public static void traverse(BinaryTreeNode root) {
		
		if (root == null) {
			return;
		}
		
		traverse(root.leftChild);		
		System.out.printf("Node: %d\n", root.data);
		traverse(root.rightChild);
		
	}

	public static void main(String[] args) {

		BinaryTreeNode rootOne = BinarySearchTreeInsert.insert(null, 5);
		rootOne = BinarySearchTreeInsert.insert(rootOne, 2);
		rootOne = BinarySearchTreeInsert.insert(rootOne, 7);
		rootOne = BinarySearchTreeInsert.insert(rootOne, 1);
		
		BinaryTreePostOrderTraversal.traverse(rootOne);
		

		
	}

}
