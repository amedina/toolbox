package com.medina.toolbox.arrays;

public class SmallestElementCyclicArray {


	/*
	 *  Design a O(logN) algorithm to find the smallest element in a
	 *  cyclically sorted array. 
	 */
	
	public static int findSmallest(int[] a) {
		
		int l = 0;
		int h = a.length - 1;
		
		while (l < h) {
			
			int m = l + ((h - l) >> 1);
		
			if (a[m] <= a[h]) {
				h = m;
			}else {
				l = m + 1;
			}
		}
		
		return l;
	}
	
	public static void main(String[] args) {
		
		
		int[] a = {279, 368, 378, 478, 550, 631,103, 203, 220, 234};
		
//		PrintArray.print(a);
//		RotateArray.rotate(a, 6, RotateArray.RIGHT);
//		PrintArray.print(a);

		int i = SmallestElementCyclicArray.findSmallest(a);
		
		System.out.printf("i: %d s: %d", i, a[i]);
	}

}
