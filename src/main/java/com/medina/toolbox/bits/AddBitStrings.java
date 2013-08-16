package com.medina.toolbox.bits;

public class AddBitStrings {

	
	public String padString(String a, int n) {
		
		String res = "";
		
		for (int i = 0; i < n; i++) {
			res += "0";
		}
		
		res += a;
		
		return res;
		
	}
	
	/*
	 * Idea: Pad the smaller string with 0's to the left.
	 * Perform addition one digit at a time, starting with the LSB
	 * 
	 * Key observation: there will be a carry if at least two of the elements 
	 * involved in the single digit sum are ones:
	 * 
	 *  (1) (ai & bi); (2) (ai & carryOn); (3) (bi & carryOn)
	 * 
	 */
	public String addBitStrings(String a, String b) {
		
		String res = "";
		
		/* Pad smaller string to make both equal size */
		if (a.length() < b.length()) {
			a = padString(a, b.length() - a.length());
		}else {
			if (b.length() < a.length()) {
				b = padString(b, a.length() - b.length());
			}
		}
		
		int carryOn = 0;
		for (int i = a.length() - 1; i >= 0 ; i--) {
			int ai = Integer.valueOf(a.charAt(i)) - '0';
			int bi = Integer.valueOf(b.charAt(i)) - '0';
			int sum = ai ^ bi ^ carryOn;
			carryOn = (ai & bi) | (ai & carryOn) | (bi & carryOn);
			res = String.valueOf(sum) + res;			
		}
		
		if (carryOn == 1) {
			res = "1" + res;
		}
				
		return res;
		
	}
	
	public static void main(String[] args) {

		AddBitStrings ab = new AddBitStrings();
		String a = "1001011";
		String b = "101";
		String res = ab.addBitStrings(a, b);
		System.out.printf("A: %s\nB: %s\nA + B: %s", a, b, res);
		
		
	}

}
