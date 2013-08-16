package com.medina.toolbox.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKLargestFromArray {


	/*
	 * Write an efficient program for printing k largest elements in an array. 
	 * Elements in array can be in any order.
	 */
	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);	
		}
		System.out.println("");
	}
	
	
	/* Solution #1:
	 * 
	 * APPROACH: Sorting-based
	 *
	 * Complexity: O(NlogN)
	 * 
	 * IDEA: Sort the array; traver the sorted array form the back towards the end, filling 
	 * up resulting array
	 * 
	 */
	public int[] solutionOne(int[] a, int k) throws IllegalArgumentException {
		
		int[] res = new int[k];
		
		if (a == null || a.length < k) {throw new IllegalArgumentException();}
		
		Arrays.sort(a);
		
		int j = k - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			res[j--] = a[i];
			if (j < 0) break;
		}
		
		return res;
	}
	
	
	/* 
	 * Solution #2: 
	 * 
	 * APPROACH: Priority-Queue
	 * IDEA: Insert ALL elements from A into PriorityQueue
	 * COMPLEXITY: O(NlogN);
	 */
	public int[] solutionTwo(int[] a, int k) throws IllegalArgumentException {
		
		if (a == null || a.length < k) {throw new IllegalArgumentException();}
		
		/* Define Min-PriorityQueue of Integers (MIN element always at top of Queue) */
		Comparator<Integer> comp = new MaxHeapComparator(); 
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(a.length, comp);
		
		/* Populate Priority Queue with all elements of A: O(NLogN); */
		for (int i = 0; i < a.length; i++) {
			q.add(a[i]);
		}
		
		/* Extract K elements from the Queue: O(KLogK) */
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = q.remove();
		}
		
		return res;
	}
	
	
	/* 
	 * Solution #3: 
	 * 
	 * APPROACH: Priority-Queue
	 * IDEA: Insert ALL only K elements from A into PriorityQueue
	 * COMPLEXITY: O(NlogK);
	 */
	public int[] solutionThree(int[] a, int k) throws IllegalArgumentException {
		
		if (a == null || a.length < k) {throw new IllegalArgumentException();}
		
		/* Define Min-PriorityQueue of Integers (MIN element always at top of Queue) */
		Comparator<Integer> comp = new MinHeapComparator(); 
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(a.length, comp);
		
		/* Populate Priority Queue with first K elements: O(KLogK); */
		for (int i = 0; i < k; i++) {
			q.add(a[i]);
		}
		
		/* For each of the remaining elements of the array: If a[i] > min; 
		 * then extract MIN from queue and insert a[i]
		 */
		for (int i = k; i < a.length; i++) {
			int min = q.peek();
			if (a[i] > min) {
				q.remove();
				q.add(a[i]);
			}
		}
		
		/* Extract K elements from the Queue: O(KLogK) */
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = q.remove();
		}
		
		return res;
	}
	
	private class MaxHeapComparator implements Comparator<Integer> {

		public int compare(Integer o1, Integer o2) {
			if (o1 > o2) { return -1;}
			if (o1 < o2) {return 1;}
			
			return 0;
		}
		
	}
	
	private class MinHeapComparator implements Comparator<Integer> {

		public int compare(Integer o1, Integer o2) {
			if (o1 < o2) { return -1;}
			if (o1 > o2) {return 1;}
			
			return 0;
		}
		
	}

	
	public static void main(String[] args) {
		
		FindKLargestFromArray f = new FindKLargestFromArray();
		int[] a = {1, 23, 12, 9, 30, 2, 50, 3, 6, 8, 145, 45, 198, 51};		
		f.printArray(a);
		
		int[] res = f.solutionOne(a, 3);
		System.out.print("Solution ONE: ");
		f.printArray(res);
		
		int[] b = {1, 23, 12, 9, 30, 2, 50, 3, 6, 8, 145, 45, 198, 51};		
		res = f.solutionTwo(b, 3);
		System.out.print("Solution TWO: ");
		f.printArray(res);
		
		res = f.solutionThree(b, 3);
		System.out.print("Solution THREE: ");
		f.printArray(res);
	}

}
