package com.medina.toolbox.sorting;

public class CountingSort {
	
	public void printArray(int[] a) {		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	/*
	 * Assumption: each of the n input elements is an integer in the range 1:k
	 * 
	 * Key idea: determine for each element, the number of elements thatmust
	 * come before it
	 */
	
	public int[] countingSort(int[] a, int k) {
		
		int[] b = new int[a.length];
		int[] c = new int[k + 1];
		
		for (int i = 0; i < a.length; i++) {
			c[a[i]] += 1;
		}
		
		for (int i = 2; i <= k; i++) {
			c[i] += c[i - 1];
		}
		
		int a_i = 0;
		int c_a_i = 0;
		
		for (int i = a.length - 1; i >= 0; i--) {
			
			a_i = a[i];
			c_a_i = c[a[i]];
			
			b[c_a_i - 1] = a[i];
			c[a[i]] -= 1;
		}
		
		return b;
		
	}
	public static void main(String[] args) {

		CountingSort cs = new CountingSort();
		
		int[] a = {3,6,4,1,3,4,1,4};
		int[] b = cs.countingSort(a, 6);
		
		cs.printArray(b);
		
	}

}
