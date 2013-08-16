package com.medina.toolbox.arrays;

public class BitonicSubArray {

	/*
	 * Given an array A[0 ... n-1] containing n positive integers, a subarray
	 * A[i ... j] is bitonic if there is a k with i <= k <= j such that A[i] <=
	 * A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j - 1] > = A[j]. Write a
	 * function that takes an array as argument and returns the length of the
	 * maximum length bitonic subarray.
	 * 
	 * IDEA: traverse the array from both ends; keep two arrays
	 * tracking the length of increasing and decreasing sequences respectively.
	 */
	public int getLengthOfMaxBitonicSubArray(int[] a)
			throws IllegalArgumentException {

		if (a == null || a.length == 0) {
			throw new IllegalArgumentException();
		}

		/*
		 * Keep track of sequence lengths:
		 * (1) from low to high: check a[i] <= a[i + 1] condition
		 * (2) from high to low: check a[i] >= a[i - 1] condition
		 */
		int[] inc = new int[a.length];
		int[] dec = new int[a.length];

		/* 
		 * Value of inc[i]: length of monotically increasing sequence
		 * ending at position i
		 */
		inc[0] = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				inc[i] = inc[i - 1] + 1;
			} else {
				inc[i] = 1;
			}
		}

		/* 
		 * Value of inc[i]: length of monotically decreasing sequence
		 * starting at position i
		 */

		dec[a.length - 1] = 1;
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i + 1] < a[i]) {
				dec[i] = dec[i + 1] + 1;
			} else {
				dec[i] = 1;
			}
		}

		/* To compute the MAXIMUM LENGTH of any bitonic sequence
		 * in the array, traverse EVERY i, compute inc[i] + dec[i], and
		 * keep track of the MAXIMUM sum observed.
		 */
		int maxLength = 0;
		for (int i = 0; i < a.length; i++) {
			if (inc[i] + dec[i] - 1 > maxLength) {
				maxLength = inc[i] + dec[i] - 1;
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {

		int a[] = { 12, 4, 78, 90, 45, 23 };
		int b[] = { 1, 2, 3, 4, 3, 2, 5, 1 };

		BitonicSubArray bsa = new BitonicSubArray();

		int l = bsa.getLengthOfMaxBitonicSubArray(a);
		System.out.println("ML: " + l);
		l = bsa.getLengthOfMaxBitonicSubArray(b);
		System.out.println("ML: " + l);

	}

}
