package com.medina.toolbox.trees;

public class BinaryTreeCountConfigurations {

	/* KEY IDEA: Each element in the set defined by the 
	 * range 1..n can be the root of a BinaryTree configuration
	 */
	public static int countBinaryTreeConfigurations(int n) {
		
		/* Only one possible configuration with a single node */
		if (n <= 1) {
			return 1;
		}
		
		int sum = 0;
		for (int root = 1; root <= n; root++) {
			
			int left = countBinaryTreeConfigurations(root - 1);
			int right = countBinaryTreeConfigurations(n  - root);
			
			sum += left * right;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {

		int N = 4;
		int n = BinaryTreeCountConfigurations.countBinaryTreeConfigurations(N);
		System.out.println("Num Confs: " + n);
		
	}

}
