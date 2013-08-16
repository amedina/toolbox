package com.medina.toolbox.dynamicprogramming;

public class MinNumJumpsToReachEnd {

	/*
	 * Given an array of integers where each element represents the max number of 
	 * steps that can be made forward from that element. Write a function to return 
	 * the minimum number of jumps to reach the end of the array (starting from the first element). 
	 * If an element is 0, then cannot move through that element.
	 * 
	 * Input: {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} Output: 3 (1-> 3 -> 8 ->9)
	 * 
	 * Recursive solution:
	 * 
	 * minJumps(start, end) = 1 + Math.min(minJumps(k, end)), for all k  dreachable from start
	 * 
	 * 
	 */
	
	
	/* Solution #1: (RECURSION)
	 *
	 * KEY IDA: minJumps(i) == 1 + minJumps(j) for all j reachable from i
	 */
	
	public int minJumpsRecursive(int[] a, int l, int h) {
		
		/* Base case: array of length 1*/
		if (l == h) {
			return 0;
		}
		
		/* Base case: if no jumps out of position i */
		if (a[l] == 0) {
			return Integer.MAX_VALUE;
		}
		
		/* Compute the minJumps from all j rechable from l; pick the min and add 1 */
		int minJumps = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + a[l]; i++) {
			
			System.out.printf("Computing: minJumps(%d)\n", i);
			int jumps = minJumpsRecursive(a, i, h);
			
			if (jumps != Integer.MAX_VALUE && jumps + 1 < minJumps) {
				minJumps = jumps + 1;
			}
		}		
		
		return minJumps;
	}

	/*
	 * Solution #2 (DYNAMIC PROGRAMMING): 
	 * 
	 * Recall: DP is a technique for efficiently implementing a recursive
	 * algorithm by storing partial results (CACHING)
	 * 
	 * We can observe that the problem has the "sub-problem" structure. If input
	 * is given by {1, 3, 6, 3, 2, 3, 6, 8, 9, 5}, we see that a[3] can be
	 * reached from both a[1] and a[2]; therefore the problem minJumps(3,9) will
	 * be computed once for minJump(1,9) and once for minJumps(2,9).
	 * 
	 * KEY IDEA: Keep array to keep track of the jumps needed to reach position
	 * i from 0; return jumps[n - 1] at the end.
	 * 
	 */

	public int minJumpsDP(int[] a) {

		int[] jumps = new int[a.length];
		jumps[0] = 0;
		
		/* KEY IDEA: Find the number of jumps to reach a[i] from a[0] */

		for (int i = 1; i < a.length; i++) {

			jumps[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j < i; j++) {
				if (i <= j + a[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = jumps[j] + 1;
					break;
				}
			}

		}

		return jumps[a.length - 1];
		
	}

	public static void main(String[] args) {

		MinNumJumpsToReachEnd m = new MinNumJumpsToReachEnd();
		int[] a = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		
		int n = m.minJumpsRecursive(a, 0, a.length - 1);
		System.out.printf("RECURSIVE MinJumps: %d\n", n);
		
		n = m.minJumpsDP(a);
		System.out.printf("DYNAMIC PROGRAMMING MinJumps: %d", n);
	}

}
