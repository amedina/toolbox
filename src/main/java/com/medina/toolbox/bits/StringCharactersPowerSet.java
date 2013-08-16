package com.medina.toolbox.bits;

import java.util.ArrayList;

public class StringCharactersPowerSet {

	/*
	 * Idea: there is a one-to-one correspondence between the ordering of
	 * elements in a set S and bit vectors of size |S|
	 */

	public static void generateStringCharactersPowerSet(String s) {

		/* 
		 * Iterate over all integer from 0 to 2^|s| - 1;
		 * Pick each integer i, and "extract from it" the elements of S, which
		 * correspond to the bits set to one in the bunary representation of i
		 */
		
		for (int i = 0; i < (1 << s.length()); i++) {

			int x = i;

			System.out.printf("{");
			while (x != 0) {
				
				/* Isolate (index) of Least-Significant One Bit (x & ~(x - 1))*/
				int lsbIndex = ((int)(Math.log(x & ~(x - 1))/Math.log(2.0)));
				
				/* Output element */
				System.out.printf("%s", s.charAt(lsbIndex));
				
				/* Clear the LSB bit in x*/
				x = x & (x - 1);
				
			}
			
			System.out.printf("}\n");

		}
	}

	public static void main(String[] args) {

		String s = "abcdef";
		StringCharactersPowerSet.generateStringCharactersPowerSet(s);
		
	}

}
