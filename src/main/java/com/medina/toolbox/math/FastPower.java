package com.medina.toolbox.math;

public class FastPower {


	/*
	 * KEY IDEA
	 * 
	 * Based on the observation: n = floor(n/2) + ceil(n/2)
	 * 
	 * if (n%2 == 0): a^n = (a^n/2)^2
	 * if (n%2 == 1): a^n = a(a^floor(n/2))^2
	 */
	
	public static int fastPower(int a, int n) {
		
		if (n == 0) return 1;
		
		int x = fastPower(a, (int)Math.floor(n/2));
		
		if (n % 2 == 0) {
			return x * x;			
		}else {
			return a * x * x;
		}
		
	}
	public static void main(String[] args) {
		
		int a = 8;
		int n = 3;
		long p = FastPower.fastPower(a, n);
		System.out.println("a: " + a + " n: " + n + " P: " + p);

		a = 2;
		n = 2;
		p = FastPower.fastPower(a, n);		
		System.out.println("a: " + a + " n: " + n + " P: " + p);
		
		a = 3;
		n = 2;
		p = FastPower.fastPower(a, n);		
		System.out.println("a: " + a + " n: " + n + " P: " + p);
		
		a = 2;
		n = 40;
		p = FastPower.fastPower(a, n);		
		System.out.println("a: " + a + " n: " + n + " P: " + p);
	}

}
