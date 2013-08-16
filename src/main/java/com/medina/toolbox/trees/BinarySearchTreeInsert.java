package com.medina.toolbox.trees;

public class BinarySearchTreeInsert {

	public static BinaryTreeNode insert(BinaryTreeNode root, int data) {
						
		if (root == null) {
			return new BinaryTreeNode(data);
		}
		
		if (root.data >= data) {
			root.leftChild = insert(root.leftChild, data);
			root.leftChild.parent = root;
		}else {
			root.rightChild = insert(root.rightChild, data);
			root.rightChild.parent = root;
		}
		
		return root;
		
	}
	
	public static BinaryTreeNode insert(BinaryTreeNode root, BinaryTreeNode newNode) {
		
		if (root == null) {
			return newNode;
		}
		
		if (root.data >= newNode.data) {
			root.leftChild = insert(root.leftChild, newNode);
			root.leftChild.parent = root;
		}else {
			root.rightChild = insert(root.rightChild, newNode);
			root.rightChild.parent = root;
		}
		
		return root;
		
	}

	public static void main(String[] args) {


	}

}
