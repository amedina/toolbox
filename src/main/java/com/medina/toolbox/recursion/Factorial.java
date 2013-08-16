package com.medina.toolbox.recursion;

public class Factorial {


	public static int factorialSimple(int n) {
		
		if (n == 0 || n == 1) {
			return 1;
		}
		
		return n * factorialSimple(n - 1);
		
	}
	
	public static int[] factorialAll(int n) {
		
		int[] f = new int[n];
		
		factorialAllAux(n, 0, f);
		
		return f;
	}
	
	public static int factorialAllAux(int n, int level, int[] f) {
		
		if (n > 1) {
			f[level] = n * factorialAllAux(n - 1, level + 1, f);
			return f[level];
		}
		
		f[level] = 1;
		return 1;
		
	}
	
	public static long factorialIterative(int n) {
		
		long fact = 1;
		
		while (n > 1) {
			fact *= n;
			n -= 1;
		}
		
		return fact;
	}
	
	public static void main(String[] args) {

		int n = 10;
		int nFact = Factorial.factorialSimple(n);
		System.out.println("Fib(" + n + "): " + nFact);
		
		int[] f = Factorial.factorialAll(n);
		for (int i = 0; i < f.length; i++) {
			System.out.print("Fib(" + (n - i) + "): " + f[i] + " ");
		}
		System.out.println("");
		
		n = 6;
		nFact = Factorial.factorialSimple(n);
		System.out.println("FibSimple(" + n + "): " + nFact);
		
		f = Factorial.factorialAll(n);
		for (int i = 0; i < f.length; i++) {
			System.out.print("Fib(" + (n - i) + "): " + f[i] + " ");
		}
		System.out.println("");
		
		
	}

}
