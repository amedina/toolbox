package com.medina.toolbox.dynamicprogramming;


public class BinomialCoefficients {

	int[][] bc;
	
	public BinomialCoefficients(int n) {
		
		bc = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; i++) {
			bc[i][0] = 1;			
		}
		
		for (int j = 0; j <= n; j++) {
			bc[j][j] = 1;			
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {				
				bc[i][j] = bc[i - 1][j] + bc[i - 1][j - 1];
			}
		}		
	}
	
	public int binomialCoeff(int n, int k) {		
		return bc[n][k];
	}
	
	
	public static void main(String[] args) {

		BinomialCoefficients b = new BinomialCoefficients(10);
		
		int n = 5;
		int k = 1;
				
		System.out.printf("BC[%d][%d] = %d\n", n, k, b.binomialCoeff(n, k));
		
		n = 5;
		k = 2;			
		System.out.printf("BC[%d][%d] = %d\n", n, k, b.binomialCoeff(n, k));
		
		n = 5;
		k = 3;			
		System.out.printf("BC[%d][%d] = %d\n", n, k, b.binomialCoeff(n, k));
		n = 5;
		k = 4;			
		System.out.printf("BC[%d][%d] = %d\n", n, k, b.binomialCoeff(n, k));
	}

}
