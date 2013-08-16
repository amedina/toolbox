package com.medina.toolbox.arrays;

public class FindMaximumInBitonicArray {

	/*
	 * PIVOT: element in the array where the monotonically increasing
	 * sub-array ends; 
	 * 
	 * APPROACH: Apply a BINARY SEARCH to find 
	 * the pivot point. If the array does no have a pivot point, 
	 * return -1
	 */
	public int searchPivot(int[] a, int l, int h) {
		
		if (l == h) {
			return -1;
		}
		
		int m = l + (h - l)/2;
		
		/*
		 * KEY: Variation of Binary-Search approach: check
		 * for a[m] > a[m+1], instead of a[m] = target
		 */
		if (a[m] > a[m + 1]) {
			return m;
		}
		
		/* 
		 * KEY: If the section of the array between l AND m is monotonically
		 * decreasing (a[l] > a[m]), then look for the pivot of the left half of the array;
		 * otherwise, search for the pivot on the right side of the array
		 */
		if (a[l] > a[m]) {
			return searchPivot(a, l, m);
		}else {
			return searchPivot(a, m + 1, h);
		}
	}
	
	public int findMax(int[] a) {
		
		int p = searchPivot(a, 0, a.length - 1);
		
		if (p < 0) {
			return a[a.length - 1];
		}
		
		return a[p];
		
	}
	public static void main(String[] args) {

		FindMaximumInBitonicArray m = new FindMaximumInBitonicArray();
		int[] a = {1, 30, 40, 50, 60, 70, 23, 20};
		int[] b = {1, 30, 40, 50, 60, 70, 80, 90, 100, 90, 80};
		int max = m.findMax(a);
		System.out.println("MaxA: " + max);
		
		max = m.findMax(b);
		System.out.println("MaxB: " + max);
	}

}
