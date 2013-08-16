package com.medina.toolbox.arrays;

import java.util.Arrays;

public class BinarySearchUnknownLength {

	
	@SuppressWarnings("unused")
	public static Integer binarySearch(int[] a, int k) {
		
		/* 
		 * Find the **effective** end of the array 
		 * IDEA: Jump with exponential steps until with either 
		 * (1) reach the end of the array, or
		 * (2) find an element whose value is greater than the target 
		 *
		 */

		int p = 0;
		while (true) {
			
			try {
				
				int index = (1 << p) - 1;
				int val = a[index];
				
				if (val == k) { 
					return index;
				}
				
				if (val > k) {
					break;
				}
				
			}catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
			
			p += 1;
			
		}
		
		/* 
		 * Do Binary Search!
		 *
		 * The boundaries of the binary search are given by:
		 * LEFT: the power of two computed before the initial loop ended
		 * RIGHT: 
		 */
		int l = (1 << (p - 1));
		int r = (1 << p) - 1;
		
		while (l <= r) {
			
			int m = l + ((r - l) >> 1);
			
			try {
				
				int val = a[m];

				if (val == k) {
					return m;
				}
				if (val > k) {
					r = m - 1;
				}else {
					l = m + 1;
				}
				
			}catch (ArrayIndexOutOfBoundsException e) {
				r = m - 1;
			}			
		}
		
		return -1;
	}

	public static void main(String[] args) {

		int[] a = {11,15,14,16,17,8,4,5,6,3,25,6,4,10,12,11,13,14,1,5,16,18,19,20,23};
		Arrays.sort(a);
		PrintArray.print(a);
		int k  = 14;
		Integer p = BinarySearchUnknownLength.binarySearch(a, k);
		
		System.out.println("END " + p);
		
	}

}
