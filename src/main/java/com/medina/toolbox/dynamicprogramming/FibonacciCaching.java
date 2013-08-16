package com.medina.toolbox.dynamicprogramming;

import java.util.ArrayList;

public class FibonacciCaching {

	private static final long UNKNOWN = -1L;
	ArrayList<Long> f;
	
	public long fibAux(int n) {
		
		if (f.get(n) == UNKNOWN) {
			long fn = fibAux(n - 1) + fibAux(n - 2);
			f.set(n, fn);
		}
		
		return f.get(n);
		
		
	}
	
	public long fib(int n) {

		f = new ArrayList<Long>(n);
		f.add(0L);
		f.add(1L);
		
		for (int i = 2; i < n; i++) {
			f.add(UNKNOWN);
		}
		
		return fibAux(n);
	}
	
	public static void main(String[] args) {
	
		FibonacciCaching fc = new FibonacciCaching();
		
		int n = 10;
		long fn = fc.fib(n);
		
		System.out.printf("FCACHING(%d) : %ld", n, fn);
		

	}

}
