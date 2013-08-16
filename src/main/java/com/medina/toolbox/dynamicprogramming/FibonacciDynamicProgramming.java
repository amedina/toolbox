package com.medina.toolbox.dynamicprogramming;

import java.util.ArrayList;

public class FibonacciDynamicProgramming {

	private ArrayList<Long> f = new ArrayList<Long>();
	
	public long fibDP(int n) {
		
		f.add(0L);
		f.add(1L);
		
		for (int i = 2; i <= n; i++) {
			f.set(i, f.get(i - 1) + f.get(i - 2));
		}
		
		return f.get(n);
		
	}

	public static void main(String[] args) {
		
		FibonacciDynamicProgramming fdp = new FibonacciDynamicProgramming();
		
		int n = 10;
		long f = fdp.fibDP(n);
		
		System.out.printf("FDP(%D): %ld", n, f);

	}

}
