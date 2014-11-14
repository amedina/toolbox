package com.medina.toolbox.trees;

public class IntervalTreeNode {

	public Interval data;
	BinaryTreeNode parent;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	public IntervalTreeNode(Interval data) {		
		this.data = data;
		parent = null;
		leftChild = null;
		rightChild = null;
	}
	
}