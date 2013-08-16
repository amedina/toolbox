package com.medina.toolbox.recursion;

public class BinarySearch {

	public static int search(int[] a, int l, int r, int x) throws IllegalArgumentException {
		
		int range = r - l;
		if (range < 0) {
			throw new IllegalArgumentException();
		}
					
		int m = l + (range/2);
		if (a[m] == x) {
			return m;			
		}
		
		if (a[m] > x) {
			return search(a, l, m - 1, x);
		}else {
			return search(a, m + 1, r, x);
		}		
	}
	
	
	public static int searchIterative(int[] a, int l, int r, int x) {
		
		while (l <= r) {
		
			int range = r - l;
						
			int m = l + (range/2);
			if (a[m] == x) {
				return m;			
			}
			
			if (a[m] > x) {
				r = m - 1;
			}else {
				l = m + 1;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		int[] a = {20,21,22,23,24,45,47,49,51,53,57,61,62,63,69};
		
		int x = 49;
		int index = BinarySearch.search(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 62;
		index = BinarySearch.search(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 20;
		index = BinarySearch.search(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 23;
		index = BinarySearch.search(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 21;
		index = BinarySearch.search(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 53;
		index = BinarySearch.search(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 69;
		index = BinarySearch.search(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		System.out.println("******************************");

		x = 49;
		index = BinarySearch.searchIterative(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 62;
		index = BinarySearch.searchIterative(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 20;
		index = BinarySearch.searchIterative(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 23;
		index = BinarySearch.searchIterative(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 21;
		index = BinarySearch.searchIterative(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 53;
		index = BinarySearch.searchIterative(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);
		
		x = 69;
		index = BinarySearch.searchIterative(a, 0, a.length, x);
		System.out. println("Element: " + x + " I: " + index);

	}

}
