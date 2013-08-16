package com.medina.toolbox.arrays;

import java.util.Arrays;

public class SubsetArray {

	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);	
		}
		System.out.println("");
	}
	
	public boolean isSubset(int[] a, int[] b) {
	
		Arrays.sort(a);
		Arrays.sort(b);
		
		printArray(a);
		printArray(b);
		
		if (a.length > b.length) {
			return false;
		}
		
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				i++;
				j++;
			}else {
				if (a[i] < b[j]) {
					return false;
				}else {
					j++;
				}
			}
		}
		
		if (i < a.length) {
			return false;
		}
		
		return true;
	
	}
	
	
	public static void main(String[] args) {
	
		SubsetArray sa = new SubsetArray();
		int[]  a = {1,2,9};
		int[] b = {7,5,4,6,5,1,2,3,5,4,6,10,11,9,6};
		boolean r = sa.isSubset(a, b);
		
		System.out.println("R: " + r);

	}

}
