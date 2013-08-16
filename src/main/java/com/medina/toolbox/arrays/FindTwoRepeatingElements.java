package com.medina.toolbox.arrays;

public class FindTwoRepeatingElements {

	/*
	 * You are given an array of n+2 elements. All elements of the array are in
	 * range 1 to n. And all elements occur once except two numbers which occur
	 * twice. Find the two repeating numbers.
	 * 
	 * For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
	 * 
	 * The above array has n + 2 = 7 elements with all elements occurring once
	 * except 2 and 4 which occur twice. So the output should be 4, 2.
	 * 
	 * KEY OBSERVATION: range restriction. Notice that there is a
	 * correlation between the range restriction and the indices of the array;
	 * we can use that information to isolate the repeating numbers.
	 * 
	 * STRATEGY:
	 * 
	 * (1) Compute CUMMULATIVE XOR of all elements of Array
	 * (2) 
	 */
	
	public void findRepetingElementsMethodOne(int[] a) {
	
		/* Keep the aggregate XOR operation */
		int xor = 0;
		
		for (int i = 0; i < a.length; i++) {
			xor ^= a[i];
		}
		
		for (int i = 0; i < a.length - 1; i++) {
			xor ^= i;
		}
		
		/* Isolate the right-most bit set in xor */
		int rightMostBitSet = xor & ~(xor - 1);
		

		/* Revert process to get actual numbers */
		int x = 0, y = 0;
		for (int i = 0; i < a.length; i++) {
			if ((a[i] & rightMostBitSet) > 0) {
				x ^= a[i];
			}else {
				y ^= a[i];
			}
		}

		for (int i = 0; i < a.length - 1; i++) {
			if ((i & rightMostBitSet) > 0) {
				x ^= i;
			}else {
				y ^= i;
			}
		}
		
		System.out.printf("Repeated elements: x: %d y: %d\n", x, y);
	}
	
	public void findRepetingElementsMethodTwo(int[] a) {
	
		for (int i = 0; i < a.length; i++) {
			if (a[Math.abs(a[i])] > 0) {
				a[Math.abs(a[i])] *= -1;
			}else {
				System.out.printf("Repeated element: %d\n", Math.abs(a[i]));
			}
		}
	}
	
	public static void main(String[] args) {
		
		FindTwoRepeatingElements f = new FindTwoRepeatingElements();
		int[] a = {4, 2, 4, 5, 2, 3, 1};
		f.findRepetingElementsMethodOne(a);
		f.findRepetingElementsMethodTwo(a);
	}

}
