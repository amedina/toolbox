package com.medina.toolbox.arrays;

import java.util.Arrays;

public class MinimumLengthUnsortedSubArrray {


	/*
	 * The goal of this problem is to find the the minimum subarray that, if
	 * sorted, would make the whole array sorted
	 * 
	 * The algorithm involves the following steps:
	 * 
	 * (1) From left to right, find first index where a[i] > a[i + 1] --> s
	 * (2) From right to left, find first index where a[i] < a[i - 1] --> e
	 * (3) Find min from a[s:e] --> min
	 * (4) Find max from a[s:e] --> max
	 * (5) from left to right, find index of first element that a[i] >= min --> s
	 * (6) From right to left, find index of first element that a[i] <= max -->e
	 */
	
	public int findMin(int[] a, int s, int e) throws IllegalArgumentException {
		
		if (s < 0 || e > a.length) {
			throw new IllegalArgumentException();
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = s; i <= e; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		
		return min;
	}
	
	public int findMax(int[] a, int s, int e) throws IllegalArgumentException {
		
		if (s < 0 || e > a.length) {
			throw new IllegalArgumentException();
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = s; i <= e; i++) {
			if (a[i] > max) {
			 max = a[i];
			}
		}
		
		return max;
	}
	
	public void findMinUnsortedSubArray(int[] a) {
		
		/* STEP #1: Find first "unsorted" element from left */
		int s = 0;
		for (; s < a.length; s++) {
			if (a[s] > a[s + 1]) {
				break;
			}
		}
				
		if (s == a.length) {
			System.out.println("Array is fully sorted!");
			return;
		}
		
		/* STEP #2: Find first "unsorted" element from right */
		int e = a.length - 1;
		for (; e > 0; e--) {
			if (a[e] < a[e - 1]) {
				break;
			}
		}
		
		/* STEP #3: Find min and max elements in the above range */
		int min = findMin(a, s, e);
		int max = findMax(a, s, e);
		
		
		/* STEP #4: Find first element from left lower than min */
		for (int i = 0; i < a.length; i++) {
			if (a[i] > min) {
				s = i;
				break;
			}
		}
		
		/* STEP #5: Find first element from right higher than max */
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] < max) {
				e = i;
				break;
			}
		}

		System.out.printf("S: %d E: %d\n", s, e);
		
	}
	
	public void findMinUnsortedSubArrayDriver() {
		
		int[] a = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int[] b = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		
		PrintArray.print(a);
		findMinUnsortedSubArray(a);
		Arrays.sort(a);
		PrintArray.print(a);
		
		PrintArray.print(b);
		findMinUnsortedSubArray(b);
		Arrays.sort(b);
		PrintArray.print(b);
		
	}
	public static void main(String[] args) {

		MinimumLengthUnsortedSubArrray m = new MinimumLengthUnsortedSubArrray();
		m.findMinUnsortedSubArrayDriver();
	}

}
