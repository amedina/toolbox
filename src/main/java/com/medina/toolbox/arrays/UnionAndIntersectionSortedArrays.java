package com.medina.toolbox.arrays;

import java.util.ArrayList;

import com.medina.toolbox.trees.BinarySearchTreeBuild;
import com.medina.toolbox.trees.BinaryTreeInOrderTraversal;
import com.medina.toolbox.trees.BinaryTreeNode;

public class UnionAndIntersectionSortedArrays {

	public static int[] union(int[] a, int[] b) {
		
		int[] c = new int[a.length + b.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			
			if (a[i] == b[j]) {
				c[k++] = a[i++];
				j++;
				continue;
			}
			
			if (a[i] < b[j]) {
				c[k++] = a[i++];
				continue;
			}
			
			if (a[i] > b[j]) {
				c[k++] = b[j++];
				continue;
			}
			
		}
		
		while (i < a.length) {
			c[k++] = a[i++];
		}
		
		while (j < b.length) {
			c[k++] = b[j++];
		}
	
		return c;
		
	}
	
	public static int[] intersection(int[] a, int[] b) {
		
		int[] c = new int[Math.min(a.length, b.length)];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < a.length && j < b.length) {

			if (a[i] == b[j]) {
				c[k++] = a[i++];
				j++;
				continue;
			}
			
			if (a[i] < b[j]) {
				i++;
				continue;
			}
			
			if (a[i] > b[j]) {
				j++;
				continue;
			}
			
		}
		
		
		return c;
	}
	
	public static ArrayList<BinaryTreeNode> union(ArrayList<BinaryTreeNode> a, ArrayList<BinaryTreeNode> b) {
		
		ArrayList<BinaryTreeNode> c = new ArrayList<BinaryTreeNode>();
		
		int i = 0, j = 0;
		
		while (i < a.size() && j < b.size()) {
			
			if (a.get(i).data == b.get(j).data) {
				c.add(a.get(i++));
				j++;
				continue;
			}
			
			if (a.get(i).data < b.get(j).data) {
				c.add(a.get(i++));
				continue;
			}
			
			if (a.get(i).data > b.get(j).data) {
				c.add(b.get(j++));
				continue;
			}
			
		}
		
		while (i < a.size()) {
			c.add(a.get(i++));
		}
		
		while (j < b.size()) {
			c.add(b.get(j++));
		}
	
		return c;
		
	}
	
	public static ArrayList<BinaryTreeNode> intersection(ArrayList<BinaryTreeNode> a, ArrayList<BinaryTreeNode> b) {
		
		ArrayList<BinaryTreeNode> c = new ArrayList<BinaryTreeNode>();
		
		int i = 0, j = 0;
		
		while (i < a.size() && j < b.size()) {

			if (a.get(i).data == b.get(j).data) {
				c.add(a.get(i++));
				j++;
				continue;
			}
			
			if (a.get(i).data < b.get(j).data) {
				i++;
				continue;
			}
			
			if (a.get(i).data > b.get(j).data) {
				j++;
				continue;
			}
			
		}
		
		
		return c;
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}
	
	public static void main(String[] args) {

//		int[] a = {1,3,4,5,7};
//		int[] b = {2,3,5,6};
//		
//		int[] c = UnionAndIntersectionSortedArrays.union(a, b);
//		UnionAndIntersectionSortedArrays.printArray(a);
//		UnionAndIntersectionSortedArrays.printArray(b);
//		UnionAndIntersectionSortedArrays.printArray(c);
//		
//		c = UnionAndIntersectionSortedArrays.intersection(a, b);
//		UnionAndIntersectionSortedArrays.printArray(c);
//		
		int[] a1 = {6, 5, 4, 6, 7, 8};		
		int[] a2 = {5, 4, 7};
		BinaryTreeNode root1 = BinarySearchTreeBuild.build(a1);
		BinaryTreeNode root2 = BinarySearchTreeBuild.build(a2);

		ArrayList<BinaryTreeNode> seq1 = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(root1, seq1);
		ArrayList<BinaryTreeNode> seq2 = new ArrayList<BinaryTreeNode>();
		BinaryTreeInOrderTraversal.getInOrderNodes(root2, seq2);
		
		ArrayList<BinaryTreeNode> union = UnionAndIntersectionSortedArrays.union(seq1, seq2);
		for (int i = 0; i < union.size(); i++) {
			System.out.println("U: " + union.get(i).data);
		}
		System.out.println("----");
		ArrayList<BinaryTreeNode> intersection = UnionAndIntersectionSortedArrays.intersection(seq1, seq2);
		for (int i = 0; i < intersection.size(); i++) {
			System.out.println("I: " + intersection.get(i).data);
		}

	}

}
