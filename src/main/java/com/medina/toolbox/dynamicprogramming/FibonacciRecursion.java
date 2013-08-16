package com.medina.toolbox.dynamicprogramming;

public class FibonacciRecursion {

	/* 
	 * 	
	 * fib(0) = 0
	 * fib(1) = 1
	 * 
	 * fib(n) = fib(n - 1) _ fib(n -2)
	 */
	long fib(int n) {
		
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		return fib(n -1) + fib(n - 2);
	}
	
	
	public static void main(String[] args) {
	
		FibonacciRecursion fr = new FibonacciRecursion();
		
		int n = 10;
		long f = fr.fib(n);
		
		System.out.printf("FREC(%d) : %ld", n, f);

	}

}
