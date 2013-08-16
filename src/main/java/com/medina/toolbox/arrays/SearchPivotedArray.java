package com.medina.toolbox.arrays;

public class SearchPivotedArray {

	
	/* Find Pivot: BINARY SEARCH APPROACH (RECURSIVE)*/
	public static int searchPivot(int[] a, int l, int h) {
				
		if (l == h) {
			return -1;
		}
		
		int m = l + (h - l)/2;
		
		/* If middle element is larger than the next, we have found the pivot */
		if (a[m] > a[m + 1]) {
			return m;
		}
		
		if (a[l] > a[m]) {
			return searchPivot(a, l, m);
		}else {
			return searchPivot(a, m + 1, h);
		}
	}
	
	/* BINARY SEARCH Algorithm */
	public static int binarySearch(int[] a, int l, int h, int x) {
		
		if (l > h) {
			return -1;
		}
		
		int m = l + (h - l)/2;
		if (a[m] == x) {
			return m;
		}
		
		if (a[m] > x) {
			return binarySearch(a, l, m - 1, x);
		}else {
			return binarySearch(a, m + 1, h, x);
		}
		
	}
	
	public static int searchPivotedArray(int[] a, int x) {
		
		/* STEP #1: Find the location of the pivot element */
		int p = searchPivot(a, 0, a.length - 1);
		
		/* Of p == -1, a pivot was not found */
		if (p < 0) {
			System.out.println("Array does not have a pivot!");
			return -1;
		}
		
		/* STEP #2: If pivot element equals target, return it */
		if (a[p] == x) {
			return p;
		}
		
		/*
		 *  STEP #3: if element at pivot is greater than target, then
		 * do a binary search on first half of array; otherwise peform
		 * a binary search on the second half of the array
		 * 
		 */
		if (a[p] > x && a[0] < x) {
			return binarySearch(a, 0, p - 1, x);
		}else {
			return binarySearch(a, p + 1, a.length - 1, x);
		}
	}

	public static void main(String[] args) {

		int[] a = {9,10,11,12,13,14,1,2,3,4,5,6,7,8};
		int[] b = {10,11,12,13,14,1,2,3,4,5,6,7,8};
		int[] c = {1,2,3,4,5,6,7,8,910,11,12,13,14};
				
		int p = SearchPivotedArray.searchPivot(a, 0, a.length - 1);
		System.out.printf("PA: %d\n", p);
		
		p = SearchPivotedArray.searchPivot(b, 0, a.length - 1);
		System.out.printf("PB: %d\n", p);
	
		p = SearchPivotedArray.searchPivotedArray(a, 12);
		System.out.printf("SA: %d\n", p);
		
		p = SearchPivotedArray.searchPivotedArray(a, 5);
		System.out.printf("SA: %d\n", p);
		
		p = SearchPivotedArray.searchPivotedArray(a, 2);
		System.out.printf("SA: %d\n", p);
		
		p = SearchPivotedArray.searchPivotedArray(b, 5);
		System.out.printf("SB: %d\n", p);
		
		p = SearchPivotedArray.searchPivot(c, 0, c.length - 1);
		System.out.printf("PC: %d\n", p);
		
		p = SearchPivotedArray.searchPivotedArray(c, 5);
		System.out.printf("SC: %d\n", p);
	}

}
