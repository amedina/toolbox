package com.medina.toolbox.arrays;

import java.util.ArrayList;

public class PrintArray {

	public static void print(int[] a) {
		for (int i = 0; i< a.length; i++) {
			System.out.printf("%d ",  a[i]);
		}
		System.out.printf("\n");
	}
	
	public static void print(ArrayList<Integer> a) {
		for (int i = 0; i< a.size(); i++) {
			System.out.printf("%d ",  a.get(i));
		}
		System.out.printf("\n");
	}
	
	public static void print(ArrayList<Integer> a, int length) {
		for (int i = 0; i < length; i++) {
			System.out.printf("%d ",  a.get(i));
		}
		System.out.printf("\n");
	}
	
	public static void main(String[] args) {
	
	}

}
