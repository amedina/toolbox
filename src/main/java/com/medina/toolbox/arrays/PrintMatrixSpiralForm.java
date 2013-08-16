package com.medina.toolbox.arrays;

public class PrintMatrixSpiralForm {

	public void printSpiralForm(int[][] a) {
		
		int m = a.length;
		int n = a[0].length;
		
		for (int i = 0; i < m; i++)
			if (i % 2 == 0) {
				for (int j = 0; j < n; j++) {
					System.out.printf("%d ", a[i][j]);
				}
			}else {
				for (int j = n - 1; j >= 0; j--) {
					System.out.printf("%d ", a[i][j]);
				}
				
			}
	}
	
	public static void main(String[] args) {
		
		int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}; 
			
		PrintMatrixSpiralForm pm = new PrintMatrixSpiralForm();
		pm.printSpiralForm(a);
		
		

	}

}
