package com.medina.toolbox.dynamicprogramming;

import java.util.ArrayList;

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

		
	}

}
