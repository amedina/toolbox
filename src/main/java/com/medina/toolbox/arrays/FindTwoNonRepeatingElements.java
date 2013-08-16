package com.medina.toolbox.arrays;

/*
 * PROBLEM: Given an array of integers, which contains EXACTLY TWO 
 * NON REPEATING elements ;
 * 
 * APPROACH: Use properties of the XOR operation; use fact that NON REPEATING
 * elements are UNIQUE
 * 
 * (1) Compute the XOR of ALL ELEMENTS in the array: O(n)
 * (2) Isolate the RIGHTMOST (LSB) of the resulting XOR value: O(1)
 * (3) Scan the array and perform to CUMMUALTIVE XORs:
 * 	 3.1 Of ALL ELEMENTS that have the RIGHMOST BIT SET 
 *   3.2 Of ALL ELEMENTS that have the RIGHMOST BIT NOT SET
 * 
 */

public class FindTwoNonRepeatingElements {

	public void findNonRepeatingElements(int[] a) {
		
		/* (1) Compute the XOR of ALL ELEMENTS in the array */ 
		int xor = 0;
		for (int i  = 0; i < a.length; i++) {
			xor ^= a[i];
		}
	
		/* (2) Isolate the RIGHTMOST (LSB) of the resulting XOR value */
		int rightMostBit = xor & ~(xor - 1);
		
		/*
		 *  (3) Scan the array and perform to CUMMUALTIVE XORs:
		 * 	 3.1 Of ALL ELEMENTS that have the RIGHMOST BIT SET 
		 *   3.2 Of ALL ELEMENTS that have the RIGHMOST BIT NOT SET
		 */	 
		int x = 0, y = 0;
		for (int i = 0; i < a.length; i ++) {
			
			if ((a[i] & rightMostBit) > 0) {
				x ^= a[i];
			}else {
				y ^= a[i];
			}
		}
		
		System.out.printf("XOR: %d X: %d Y: %d\n",  xor, x, y);
		
	}

	public static void main(String[] args) {
		
		FindTwoNonRepeatingElements f = new FindTwoNonRepeatingElements();
		
		int[] a = {2, 3, 5, 7, 9, 5, 11, 2, 8, 3, 11, 8, 9, 14};
		f.findNonRepeatingElements(a);

	}

}
