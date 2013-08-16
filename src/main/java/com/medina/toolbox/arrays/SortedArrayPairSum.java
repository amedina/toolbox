package com.medina.toolbox.arrays;

import java.util.Arrays;


public class SortedArrayPairSum {

	/*
	 * Design an algorithm that takes a sorted array and a number k,
	 * and it returns a pair of indices in A that sum up to k. Output (-1, -1) if
	 * no such pair exists
	 */
	
	/* Solution #1: Brute force: 
	 * Define two pointers i, j; for each value of i:0...a.len - 1, check if there is 
	 * another value, using pointer j, such that a[i] + a[j] hits the target
	 * 
	 * O(1) space; O(n^2) time
	 */
	
	public Pair getPairSum(int[] a, int t) {
		
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int sum = a[i] + a[j];
				if (sum == t) {
					return new Pair(i, j);
				}
			}
		}
		
		return new Pair(-1, -1);
	}	
	
	/*
	 * Solution #2: Keep two pointer at opposite ends of the array; move them
	 * towards each other according to the current value of the pair sum; If a
	 * pair with the sum is found return it; if the pointers meet, return NOT
	 * FOUND.
	 * 
	 * O(1) space; O(n) time 
	 *
	 */
	public Pair getPairSumSolutionTwo(int[] a, int t) {
		
		int i = 0;
		int j = a.length -1;
		
		while (i < j) {
			
			int sum = a[i] + a[j]; 
			if ( sum == t) {
				return new Pair(i, j);				
			}
			
			if (sum < t) {
				i++;
			}else {			
				j--;
			}
			
		}
		
		return new Pair(-1, -1);
	}
	
	/*
	 * Solution #3: For each element of A, A[i], do a binary search of TARGET - A[i];
	 * O(1) space; O(nlogn) time;
	 */
	public Pair getPairSumSolutionThree(int[] a, int t) {
		
		for (int i = 0; i < a.length; i++) {
			
			int j = binarySearch(a, t - a[i]);
			if (j >= 0) {
				return new Pair(i, j);
			}
			
		}
		
		return new Pair(-1, -1);
		
	}
	
	public int binarySearch(int[] a, int k) {
		
		int l = 0;
		int h = a.length - 1;
		
		while (l < h) {
			
			int m  = l + (h -  l)/2;
			if (a[m] == k) {
				return m;
			}
			if (a[m] < k) {
				l = m + 1;
			}else {
				h = m - 1;
			}
		}
		
		return  -1;
		
	}
	
	private class Pair {
		
		public int i;
		public int j;
		
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Pair [i=");
			builder.append(i);
			builder.append(", j=");
			builder.append(j);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int[] a = {-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};
		
		Arrays.sort(a);
		
		PrintArray.print(a);
		
		SortedArrayPairSum ab = new SortedArrayPairSum();
		Pair p1 = ab.getPairSum(a, 167);
		Pair p2 = ab.getPairSumSolutionTwo(a, 167);
		Pair p3 = ab.getPairSumSolutionThree(a, 167);
		
		System.out.printf("P1: %s\nP2: %s\nP3: %s\n", p1.toString(), p2.toString(), p3.toString());
	}

}
