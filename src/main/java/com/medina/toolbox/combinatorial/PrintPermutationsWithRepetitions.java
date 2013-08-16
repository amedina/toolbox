package com.medina.toolbox.combinatorial;

import java.util.Arrays;

public class PrintPermutationsWithRepetitions {

	private char[] alphabet;
	
	public void printPermutations(String perm, int index, int size) {
		
		if (index == size) {
			System.out.printf("P: %s\n", perm);
			return;
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			String temp = perm;
			perm = perm + alphabet[i];	
			printPermutations(perm, index + 1, size);
			perm = temp;
		}
		
	}
	
	public void printPermutationsDriver() {
		
		String input = "FED";
		alphabet = input.toCharArray();
		Arrays.sort(alphabet); 
		
		String perm = "";
		printPermutations(perm, 0, input.length());

		return;
	}

	public static void main(String[] args) {
		
		PrintPermutationsWithRepetitions pp = new PrintPermutationsWithRepetitions();
		pp.printPermutationsDriver();
	}

}
