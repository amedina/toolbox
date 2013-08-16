package com.medina.toolbox.arrays;

import java.util.Arrays;

public class ClosestSumToZero {

	/*
	 * Problem: Given an array of integers is given, both positive and negative.
	 * You need to find the two elements such that their sum is closest to zero.
	 */
	
	/*
	 * Solution #1: Brute Force (O(nlogn))
	 * 
	 * Check all pairs; keep track of max.
	 */
	public void closestPairSumToZeroBruteForce(int[] a) {
		
		int mi = 0;
		int mj = 0;
		int minSum = Integer.MAX_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int sum = a[i] + a[j];
				if (Math.abs(sum) < minSum) {
					mi = i;
					mj = j;
					minSum = Math.abs(sum);
				}				
			}
		}
		
		System.out.printf("i: %d j: %d minSum: %d\n", mi, mj, minSum);		
	}
	
	/* Solution #2: Sort array 
	 * 
	 * KEY IDEA: Add elements from both ends of the array; if the sum of the given A[i], a[j] pair
	 * is less than the minSum so far, update it, and register the indices
	 * 
	 * If the sum is GREATER THAN 0, the decrease higher-end index (j)
	 * If the sum is LESS THAN OR EQUAL TO 0, the increase higher-end index (j)
	 * 
	 * KEY OBSERVATIONS: 
	 * 
	 * (1) Use ABSOLUTE VALUE of BOTH (current sum and minSum so far) 
	 * in the comparison against MIN_SUM
	 * (2) To CALIBRATE the sum: check if the current sum is POSITIVE
	 * or NEGATIVE; if POSITIVE reduce right-side index; if NEGATIVE
	 * increase left-side index
	 *  
	 */
	public void closestPairSumToZeroBruteForceSorting(int[] a) {
		
		int i = 0;
		int j = a.length - 1;
		int mi = 0;
		int mj = 0;
		int minSum = Integer.MAX_VALUE;
		
		Arrays.sort(a);
		
		while (i < j) {
			
			int sum = a[i] + a[j];
			if (Math.abs(sum) < Math.abs(minSum)) {
				mi = i;
				mj = j;
				minSum = sum;
			}			
			if (sum > 0) {
				j--;
			}else {
				i++;
			}
		}
		
		System.out.printf("i: %d j: %d minSum: %d\n", mi, mj, Math.abs(minSum));
		
	}
	
	
	public static void main(String[] args) {

		ClosestSumToZero cs = new ClosestSumToZero();
		int[] a = {1,60,-10,70,-80,-77,88};
		int[] b = {-10,-9,-8,0,1,2,3};
		cs.closestPairSumToZeroBruteForce(a);
		cs.closestPairSumToZeroBruteForceSorting(a);
		cs.closestPairSumToZeroBruteForce(b);
		cs.closestPairSumToZeroBruteForceSorting(b);

	}

}
