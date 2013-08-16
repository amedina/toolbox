package com.medina.toolbox.trees;

import java.util.ArrayList;

public class BinaryTreeMirror {



	
	public static void mirrorTreeTwo(BinaryTreeNode root) {
		
		if (root == null) {
			return;
		}	
		
		mirrorTreeTwo(root.leftChild);
		mirrorTreeTwo(root.rightChild);

		BinaryTreeNode temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;		
			
	}
	
	public static void main(String[] args) {

		int[] a = {2,1,3};		
		BinaryTreeNode root = BinarySearchTreeBuild.build(a);
		
		
		ArrayList<BinaryTreeNode> seq = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(root, seq);
		for (int i = 0; i < seq.size(); i++) {					
			System.out.printf("BEFORE N[%d]: %d\n", i, seq.get(i).data);
		}
		
		BinaryTreeMirror.mirrorTreeTwo(root);
		
		seq.clear();
		BinaryTreeInOrderTraversal.getInOrderNodes(root, seq);
		for (int i = 0; i < seq.size(); i++) {					
			System.out.printf("AFTER N[%d]: %d\n", i, seq.get(i).data);
		}
		
	}

}
