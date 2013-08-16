package com.medina.toolbox.arrays;

public class RotateArray {

	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	public static void printArray(int[] a) {
	
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}
	
	public static void reverse(int[] a, int i, int j) {
		
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void rotate(int[] a, int d, int direction) {
		
		int r = d;
		if (direction == RIGHT) {
			r = a.length - d;
		}
		
		reverse(a, 0, r - 1);
		reverse(a, r, a.length - 1);
		reverse(a, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10,11};
		RotateArray.printArray(a);
		
		RotateArray.rotate(a, 4, RIGHT);
		RotateArray.printArray(a);
		
		RotateArray.rotate(a, 4, LEFT);
		RotateArray.printArray(a);
		
		RotateArray.rotate(a, 4, LEFT);
		RotateArray.printArray(a);
		

	}

}
