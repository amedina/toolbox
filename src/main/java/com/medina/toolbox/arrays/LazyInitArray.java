package com.medina.toolbox.arrays;

import java.util.Random;

/*
 * Problem: Design a DETERMINISTIC scheme by which READS and
 * WRITES to an UNITIALIZED ARRAY can be made in O(1) time. May
 * use O(n) additional space; READING to an UNINITIALIZED  ENTRY
 * must return FALSE
 * 
 * APPROACH:
 * 
 * (1) The scheme will use THREE arrays: 
 * 	(-) a: array that will contain the values
 * 	(-) s: keeps track of the array entries that have been initialized so far
 * 	(-) p: maintain for each index i, the position in s
 *  (-) Initialize all arrays to MIN_VALUE;
 *  
 * (2) Maintain pointer into the next available entry in s (for next initialization)
 * (3) Implement an isValid(int i): p[i] >= 0 && p[i] < t && s[p[i]] == i
 * (4) On read(int index): if (!isValid(i)) return NULL; else return a[i]
 * (5) On write(int index, int value):
 * 
 *  	if (!isValid(index)) {
 *  		s[t] = index;
 *  		p[index] = t;
 *  		t++;
 *  	}
 *  
 *  	a[index] = val;
 * 
 */

public class LazyInitArray {

	private int[] s;
	private int[] p;
	private int[] a;
	
	int t;
	int size;
	
	public LazyInitArray(int size) {
		
		this.s = new int[size];
		this.p = new int[size];
		this.a = new int[size];
		
		for (int i = 0; i < size; i++) {
			s[i] = p[i] = a[i] = Integer.MIN_VALUE;
		}
		
		this.size = size;
		this.t = 0;
	}
	
	public boolean isValid(int i) {

		if (p[i] >= 0 && p[i] < t && s[p[i]] == i) {
			return true;			
		}
		
		return false;
	}
	
	public Integer read(int i) {
		
		if (isValid(i)) {
			return new Integer(a[i]);
		}
		
		return null;
	}
	
	public void write(int value, int i) {
		
		if (!isValid(i)) {
			s[t] = i;
			p[i] = t;
			t++;		
		}
		
		a[i] = value;
		
	}
	
	public void printArray() {
		System.out.printf("S: ");
		for (int i = 0; i < size; i++) {
			System.out.printf("%d ", s[i]);
		}
		System.out.printf("\n");
		
		System.out.printf("P: ");
		for (int i = 0; i < size; i++) {
			System.out.printf("%d ", p[i]);
		}
		System.out.printf("\n");
		
		System.out.printf("A: ");
		for (int i = 0; i < size; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}
	
	public static void main(String[] args) {
		 
		LazyInitArray a = new LazyInitArray(10);
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int index = r.nextInt(10);
			Integer v = a.read(index);
			if (v == null) {
				System.out.println("READING UNINITIALIZED ENTRY!: " + index);
			}
			a.write(r.nextInt(100), index);
		}

		a.printArray();
	}

}
