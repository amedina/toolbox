package com.medina.toolbox.combinatorial;

import java.util.Arrays;

/**
 * http://www.regentsprep.org/regents/math/algebra/apr2/LpermRep.htm
 *
 * Permutations with Repetition:
 *
 * Example: How many 3 letter words can be formed using the letters c,a,t allowing
 * for repetition of the letters?
 *
 * For this problem, 3 locations are needed:
 * 			_____  •   _____  •  _____
 * There are 3 letters which can be used to fill the first location.  Because repetition is allowed,
 * the same 3 letters can be used to fill the second location and also the last location.
 *
 * __3___  •   __3___  •  __3___   =  27 arrangements
 *
 * ===============================
 * Permutations with Repetition of Indistinguishable Objects
 * Indistinguishable objects are simply items (letters) that are repeated in the original set.  For example,
 * if the word MOM was used instead of CAT, in the example above, the two letter M's are indistinguishable
 * from one another, since they repeat.   Using MOM, some of our answers would have been duplicates of one another
 * because of the repeating M.
 *
 * If we are looking for answers that are NOT DUPLICATES (unique answers), we must deal with any letters (objects)
 * that repeat in the original set.
 *
 * The number of different permutations of n objects, where there are n1 indistinguishable objects of style 1,
 * n2 indistinguishable objects of style 2, ..., and nk indistinguishable objects of style k, is ;
 *
 *  			    n!
 *          -------------------
 *          (n1!*n2!*n3!...nk!)
 *
 */

public class PrintPermutationsWithRepetitions {

	private char[] alphabet;
	static int count = 1;

	public void printPermutations(String perm, int index, int size) {

		if (index == size) {
			System.out.printf("P(%d): %s\n", count, perm);
			count++;
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

		String input = "APPLE";
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
