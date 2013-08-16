package com.medina.toolbox.trees;

public class BinaryTreeMax {

	public static int maxValueRecursive(BinaryTreeNode root) throws IllegalArgumentException {
		
		if (root == null) {
			throw new IllegalArgumentException();
		}
		
		if (root.rightChild == null) {
			return root.data;
		}
		
		return maxValueRecursive(root.rightChild);
		
	}
	
	public static int maxValueIterative(BinaryTreeNode root) throws IllegalArgumentException {
		
		if (root == null) {
			throw new IllegalArgumentException();
		}
		
		BinaryTreeNode current = root;
		while (current.rightChild != null) {
			current = current.rightChild;
		}
		
		return current.data;
		
	}
	
	public static BinaryTreeNode maxNodeRecursive(BinaryTreeNode root) {
		
		if (root == null) {
			return null;
		}
		
		if (root.rightChild == null) {
			return root;
		}
		
		return maxNodeRecursive(root.rightChild);
		
	}
	
	public static BinaryTreeNode maxNodeIterative(BinaryTreeNode root) {
		
		if (root == null) {
			return null;
		}
		
		BinaryTreeNode curr = root;
		if (curr.rightChild != null) {
			curr = curr.rightChild;
		}
		
		return curr;
		
	}
	
	public static void main(String[] args) {
		
	}
}

