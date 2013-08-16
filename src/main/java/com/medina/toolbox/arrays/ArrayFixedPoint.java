package com.medina.toolbox.arrays;

public class ArrayFixedPoint {


	/*
	 * Given a sorted array, find a fixed point.
	 *   
	 * Solution Approach: BINARY SEARCH 
	 * 
	 * A Fixed point is a value in the array such that i == a[i]
	 * 
	 * Apply a solution similar to binary search, but with a stopping criteria comparing
	 * the value of the middle point with its index.
	 * 
	 */
	
	public int binaryFixedPointSearch(int[] a, int low, int high) {
		
		if (low > high) {
			return -1;
		}
		
		
		int m = low + (high - low)/2;
		
		if (a[m] == m) {
			return m;
		}else {		
			if (a[m] < m) {
				return binaryFixedPointSearch(a, m + 1, high);
			}else {
				return binaryFixedPointSearch(a, low, m - 1);
				
			}
		}
		
	}
	
	public static void main(String[] args) {

		ArrayFixedPoint af = new ArrayFixedPoint();
		int[]  a = {-2, -1, 3, 5, 6, 7, 8, 9, 10};
		int[]  b = {0, 2, 3, 5, 6, 7, 8, 9, 10};
		int[]  c = {-1, 1, 2, 3, 4, 5, 6, 7, 8};
		int[]  d = {-1, 0, 1, 2, 3, 5, 6, 8, 9};
		
		int fp = af.binaryFixedPointSearch(a, 0, a.length);
		System.out.printf("Fp-a: %d\n", fp);
		
		fp = af.binaryFixedPointSearch(c, 0, c.length);
		System.out.printf("Fp-c: %d\n", fp);
		
		fp = af.binaryFixedPointSearch(d, 0, d.length);
		System.out.printf("Fp-d: %d\n", fp);
	}

}
