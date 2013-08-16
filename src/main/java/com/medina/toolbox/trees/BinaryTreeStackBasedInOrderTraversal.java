package com.medina.toolbox.trees;

import java.util.Stack;

public class BinaryTreeStackBasedInOrderTraversal {

	public static void traverse(BinaryTreeNode root) {
		
		if (root == null) {
			return;
		}
		
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		
		BinaryTreeNode currNode = root;
		
		while (!s.empty() || currNode != null) {
			
			if (currNode != null) {
				s.push(currNode);
				currNode = currNode.leftChild;
			}else {
				currNode = s.pop();
				System.out.println(currNode.data);
				currNode = currNode.rightChild;
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		BinaryTreeStackBasedInOrderTraversal.traverse(root);
	}
}
