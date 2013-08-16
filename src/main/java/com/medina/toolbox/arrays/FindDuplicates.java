package com.medina.toolbox.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

	/*
	 * PROBLEM: 
	 * Given an array of n elements which contains elements from 0 to n-1, with
	 * any of these numbers appearing any number of times. Find these repeating
	 * numbers in O(n) and using only constant memory space.
	 * 
	 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer
	 * should be 1, 3 and 6.
	 * 
	 * KEY OBSERVATIONS:
	 * 
	 * (1) Take advantage of the fact that elements of the array are between 0 and n - 1
	 * (2) Set the the entry obtained by using the element's value as the index 
	 * into the array as NEGATIVE (sign of)
	 * (3) If an element a[i] is repeated, the value of a[abs(a[i])] will be negative after the
	 * first appearance of the element
	 */
	
	public static Set<Integer> printDuplicates(int[] a, int n) {
	
		Set<Integer> res = new HashSet<Integer>();
		
		for (int i = 0; i < a.length; i++) {
			
			int v = a[Math.abs(a[i])];
			if (v < 0) {
				System.out.printf("REPEATED ELEMENT: %d, %d\n", i, Math.abs(a[i]));
				res.add(Math.abs(a[i]));
			}else {
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {

		int[]  a = {1,3,4,2,1,3,2,4,5,6,7,5,6,9,10,0,3,3};
		Set<Integer> s = FindDuplicates.printDuplicates(a, 10);
		for (Integer e : s) {
			System.out.printf("REPEATED ELEMENT: %d\n", e);
		}
		
		int[] b = {4, 2, 4, 5, 2, 3, 1};
		Set<Integer> sB = FindDuplicates.printDuplicates(b, 6);
		for (Integer e : sB) {
			System.out.printf("B -- REPEATED ELEMENT: %d\n", e);
		}
	}

}
