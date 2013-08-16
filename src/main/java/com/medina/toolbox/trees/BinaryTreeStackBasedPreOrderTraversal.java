package com.medina.toolbox.trees;

import java.util.Stack;

public class BinaryTreeStackBasedPreOrderTraversal {

	public static void traverse(BinaryTreeNode root) {
		
		if (root == null) {
			return;
		}
		
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.add(root);
		
		while (!s.empty()) {
			
			BinaryTreeNode n = s.pop();
			System.out.println(n.data);
			
			if (n.rightChild != null) {
				s.add(n.rightChild);
			}
			if (n.leftChild != null) {
				s.add(n.leftChild);
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		BinaryTreeStackBasedPreOrderTraversal.traverse(root);
	}
}
