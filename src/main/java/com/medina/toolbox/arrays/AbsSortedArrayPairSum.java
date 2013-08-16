package com.medina.toolbox.arrays;

public class AbsSortedArrayPairSum {

	/*
	 * Design an algorithm that takes an abs-sorted array ans a number k,
	 * and it returns a pair of indices in A that sum up to k. Output (-1, -1) if
	 * no such pair exists
	 */
	
	/* Solution #1: Brute force: 
	 * Define two pointers i, j; for each value of i:0...a.len - 1, check if there is 
	 * another value, using pointer j, such that a[i] + a[j] hits the target
	 * 
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
	 * An effective solution that does not use the fact that
	 * the array is abs-sorted, is based on hash functions.
	 * Define a hash table with a hash function that spreads the numbers in A
	 * properly; then, for each a[i] in A, check the hash bucket for 
	 * the number k - a[i]. If there is "collision" with k - a[i], verify that the 
	 * number(s) stored in bucket do indeed correspond to k - a[i]
	 * 
	 *  O(n) space; O(n) time
	 */
	
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
		
		AbsSortedArrayPairSum ab = new AbsSortedArrayPairSum();
		Pair p = ab.getPairSum(a, 168);
		
		System.out.printf("P: %s", p.toString());
	}

}
