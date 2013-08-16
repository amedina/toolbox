package com.medina.toolbox.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePrintLevelOrder {
	
	
	public BinaryTreeNode buildTreeOne() {
		
		BinaryTreeNode root = null;
		root = BinarySearchTreeInsert.insert(root, 6);
		root = BinarySearchTreeInsert.insert(root, 5);
		root = BinarySearchTreeInsert.insert(root, 4);
		root = BinarySearchTreeInsert.insert(root, 6);
		root = BinarySearchTreeInsert.insert(root, 7);
		root = BinarySearchTreeInsert.insert(root, 8);
		
		return root;
		
	}
	
	
	/*
	 * Solution: Use a single queue to maintain the next element to be printed;
	 * every time a node is processed, its data is printed, and its children are
	 * pushed into the queue. The algorithm starts by pushing the root element
	 * into the queue; then, while the queue is not empty, pop() element from
	 * queue, print data associated with the node, and push its children into
	 * the queue.
	 */
	
	public static void printLevelOrder(BinaryTreeNode root) throws IllegalArgumentException {
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		
		if (root == null) {return;}
		
		q.add(root);
		
		while (!q.isEmpty()) {
			
			BinaryTreeNode n = q.remove();
			System.out.println(n.data);
			
			if (n.leftChild != null) {
				q.add(n.leftChild);
			}
			if (n.rightChild != null) {
				q.add(n.rightChild);
			}			
		}
		
		
	}

	public static void main(String[] args) {
		
		
		int[] a = {15, 6, 18, 3,7,17,20,2,4,13,9};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		BinaryTreePrintLevelOrder.printLevelOrder(root);
		
	}

}
