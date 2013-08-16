package com.medina.toolbox.dynamicprogramming;

public class FibonacciUltimate {


	public long fib(int n) {
		
		long back0, back1;
		
		back0 = 0;
		back1 = 1;
		
		long currSum = 0;
		for (int i = 2; i <= n; i++) {
			currSum = back0 + back1;
			back0 = back1;
			back1 = currSum;
		}

		return back0 + back1;
		
	}
	
	
	public static void main(String[] args) {
		
		FibonacciUltimate fu = new FibonacciUltimate();
		int n = 10;
		
		long f = fu.fib(n);
		
		System.out.printf("FULT(%D): %ld", n, f);
	}

}
