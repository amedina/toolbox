package com.medina.toolbox.arrays;


/* 
 * The FIXED POINT of an array is an INDEX i where u = a[i]
 * Design an algorithm to find the fixed point in an array
 * 
 * ASSUMPTION: The array has to be SORTED
 * 
 */
public class FixedPoint {

	/*
	 * Solution #1: Do a linear search --> O(n)
	 */
	
	public int findFixedPointOne(int[] a) throws IllegalArgumentException {
		
		if (a == null || a.length == 0) {throw new IllegalArgumentException();}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == i) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	/* Solution #2: Binary search (recursive) */
	public int findFixedPointTwo(int[] a, int l, int h) {
		
		if (l < h) {
			
			int m = l + (h - l)/2;
			
			if (a[m] == m) {
				return m;
			}
			
			if (m < a[m]) {
				return findFixedPointTwo(a, l, m - 1);
			}else {
				return findFixedPointTwo(a, m + 1, h);
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,4,8,9,10,88,554};
		
		FixedPoint fp = new FixedPoint();
		
		int p = fp.findFixedPointOne(a);		
		System.out.println("Fixed Point (LINEAR SEARCH): " + p);

		p = fp.findFixedPointTwo(a, 0, a.length - 1);		
		System.out.println("Fixed Point (BINARY SEARCH): " + p);

	}

}
