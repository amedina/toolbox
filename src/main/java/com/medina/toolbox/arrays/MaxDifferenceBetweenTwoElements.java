package com.medina.toolbox.arrays;


public class MaxDifferenceBetweenTwoElements {

	/*
	 * Given an array A, find the maximum difference between A[j] - A[i] such that j > i 
	 */
	
	/* 
	 * Method # 1: Brute force O(N^2)
	 * 
	 * Use two FOR LOOPS; outer loop iterates on RIGHT-SIDE of the pair (j); 
	 * INNER LOOP iterates on LEFT-SIDE of the pair.
	 */
	public int getMaxDifferenceBetweenTwoElements(int[] a) throws IllegalArgumentException {
		
		int maxSum = 0;
		
		if (a == null) {throw new IllegalArgumentException();}
		
		for (int j = 1; j < a.length; j++) {
			for (int i = 0; i < j; i++) {
				if (a[j] - a[i] > maxSum) {
					maxSum = a[j] - a[i];
				}
			}
		}
		
		return maxSum;
		
	}
	
	/*
	 * Method #2: O(N) -- ONE PASS 
	 * 
	 * Compare each element against the
	 * minimum element we have seen so far. So, we need to keep track of two
	 * things: (1) the max diff so far, and the min element so far.
	 */
	
	public int getMaxDifferenceBetweenTwoElementsEfficient(int[] a) throws IllegalArgumentException {
	
		int maxDiff = 0;		
		
		if (a == null || a.length == 0) {throw new IllegalArgumentException(); }
		
		int minElement = a[0];
		
		for (int i = 1; i < a.length; i++) {
			
			/* Keep track of the MIN SO FAR */
			if (a[i] < minElement) {
				minElement = a[i];
			}
			
			int currDiff = a[i] - minElement;
			if (currDiff > maxDiff) {
				maxDiff = currDiff;
			}				


		}
		
		return maxDiff;
	}
	
	/* 
	 * Method #3: O(N) -- TWO PASSES
	 * 
	 * Create array with difference between consecutive elements;
	 * Scan that array and compute cumulative differences (diff up to entry i);
	 * when computing the cumulative difference, keep track of maximum so far
	 */
	public int maxDifferenceBetweenTwoElementsSolutionThree(int[] a) {
		
		int[] diff = new int[a.length];
		
		diff[0] = 0;
		for (int i = 1; i < diff.length; i++) {
			diff[i] = a[i] - a[i -1];
		}
		
		int maxDiff = Integer.MIN_VALUE;
		
		for (int i = 1; i < diff.length; i++) {
			diff[i] += diff[i - 1];
			maxDiff = (diff[i] > maxDiff)?diff[i]:maxDiff;
		}
		
		return maxDiff;
	}
	
	public static void main(String[] args) {
		
		int[]  a1 = {2, 3, 10, 6, 4, 8, 1};
		int[]  a2 = {10, 8, 6, 4, 3, 2, 1};
		
		MaxDifferenceBetweenTwoElements m = new MaxDifferenceBetweenTwoElements();
		int maxSum = m.getMaxDifferenceBetweenTwoElements(a1);
		System.out.printf("Max 1: %d\n", maxSum);
		maxSum = m.getMaxDifferenceBetweenTwoElementsEfficient(a1);
		System.out.printf("Max 2: %d\n", maxSum);
		maxSum = m.maxDifferenceBetweenTwoElementsSolutionThree(a1);
		System.out.printf("Max 3: %d\n", maxSum);
		

	}

}
