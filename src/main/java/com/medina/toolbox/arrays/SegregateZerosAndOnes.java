package com.medina.toolbox.arrays;

public class SegregateZerosAndOnes {

	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}

	public void segregateZerosAndOnes(int[] a) {
		
		int l = 0;
		int r = a.length - 1;
		while (l < r) {
			
			/* Find position of first NON-ZERO element */
			while (l < r && a[l] == 0) {
				l++;
			}
			
			/* Find position of first NON-ONE element */
			while (l < r && a[r] == 1) {
				r--;
			}
			
			/* SWAP both elements */
			int temp = a[l];
			a[l] = a[r];
			a[r] = temp;
			
		}		
		
	}
	
	public static void main(String[] args) {

		SegregateZerosAndOnes s = new SegregateZerosAndOnes();
		int[] a = {0,1,1,0,1,0,0,1,1,0,1,0,1};
		s.segregateZerosAndOnes(a);
		s.printArray(a);
		
		
	}

}
