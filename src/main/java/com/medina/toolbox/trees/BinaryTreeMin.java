package com.medina.toolbox.trees;

public class BinaryTreeMin {

	public static int minValueRecursive(BinaryTreeNode root) throws IllegalArgumentException {
		
		if (root == null) {
			throw new IllegalArgumentException();
		}
		
		if (root.leftChild == null) {
			return root.data;
		}
		
		return minValueRecursive(root.leftChild);
		
	}
	
	public int minValueIterative(BinaryTreeNode root) throws IllegalArgumentException {
		
		if (root == null) {
			throw new IllegalArgumentException();}
		
		BinaryTreeNode current = root;
		
		while (current.leftChild != null) {
			current = current.leftChild;
		}
		
		return current.data;
		
	}
	
	public static BinaryTreeNode minNodeRecursive(BinaryTreeNode root) {
		
		if (root == null) {
			return null;
		}
		
		if (root.leftChild == null) {
			return root;
		}
		
		return minNodeRecursive(root.leftChild);
		
	}
	
	public static BinaryTreeNode maxNodeIterative(BinaryTreeNode root) {
		
		if (root == null) {
			return null;
		}
		
		BinaryTreeNode curr = root;
		if (curr.leftChild != null) {
			curr = curr.leftChild;
		}
		
		return curr;
		
	}
	
	public static void main(String[] args) {

	}

}
