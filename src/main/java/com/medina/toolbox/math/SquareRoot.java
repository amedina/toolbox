package com.medina.toolbox.math;

public class SquareRoot {

	private double eps = 1.0e-12;
	
	public int compare(double a, double b) {
		
		double diff = (a - b) / b;
		
		if (diff > eps) {
			return 1;
		}
		
		if (diff < -eps) {
			return -1;
		}
		
		return 0;
		
	}
	
	public double squareRoot(double x) {
		
		double l, r;
		
		if ( x < 1.0) {
			l = x;
			r = 1.0;
		}else {
			l = 1.0;
			r = x;
		}
		
		while (compare(l, r) == -1) { // While l < r
			
			double m = l + (0.5 * (r - l));
			
			double squareM = m * m;
			
			if (compare(squareM, x) == 0) {
				return m;				
			}else {
				if (compare(squareM, x) == 1) {
					r = m; 
				}else {
					l = m;
				}
			}
		}
		
		return l;
	}
	
	public static void main(String[] args) {

		SquareRoot sqrt = new SquareRoot();
		
		System.out.println("X: " + 4.0 + " SQRT: " + sqrt.squareRoot(4.0));
		System.out.println("X: " + 2.88 + " SQRT: " + sqrt.squareRoot(2.88));
	}

}
