package com.medina.toolbox.recursion;

public class StringCombinations {


	/*
	 * Print all possible combinations of the letters of a string.
	 * 
	 * In the case of combinations, the order does not matter; that is, wxyz =
	 * xywz
	 * 
	 * We need to track the output position as well as the position in the input
	 * string. 
	 */
	
	public static void combine(String s) {
		String comb = "";
		combineAux(s, 0, comb);
	}
	
	public static void combineAux(String s, int start, String comb) {
		
		for (int i = start; i < s.length(); i++) {
			
			String prevComb = comb;
			comb += s.charAt(i);
			System.out.println(comb);
			
			combineAux(s, i + 1, comb);
			comb = prevComb;
		}
		
	}
	
	public static void main(String[] args) {
		
		String s = "wxyz";
		StringCombinations.combine(s);

	}

}
