package com.medina.toolbox.math;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * A prime number (or a prime) is a natural number greater than 1 that 
 * has no positive divisors other than 1 and itself. A natural number greater 
 * than 1 that is not a prime number is called a composite number.
 * 
 * A simple but slow method of verifying the primality of a given number n is 
 * known as trial division. It consists of testing whether n is a multiple of 
 * any integer between 2 and sqrt(n).
 * 
 * Sieve of Erathostenes: ancient algorithm for finding all prime numbers up 
 * to any given limit. It does so by iteratively marking as composite (i.e. not prime) 
 * the multiples of each prime, starting with the multiples of 2. The multiples of a given 
 * prime are generated starting from that prime, as a sequence of numbers with the same 
 * difference, equal to that prime, between consecutive numbers.
 *  
 */
public class Primes {

	private static Logger log = LoggerFactory.getLogger(Primes.class);
	
	private static ArrayList<Integer> getPrimesSieve(int n) {

		ArrayList<Boolean> integerList = new ArrayList<Boolean>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
	
		/* Initialize Arrays:
		 * (1) Mark all other numbers as prime initially
		 * (2) 0, 1 not considered primes 
		 */
		
		integerList.add(false);
		integerList.add(false);

		for (int i = 2; i < n; i++) {
			integerList.add(true);
		}
		
		/* Proceed only till sqrt(n) + 1 */
		int limit = (int)(Math.pow(n, 0.5) + 1);
		
		/* Cross off non-prime numbers */
		for (int i = 2; i < limit; i++) {
			/* If the number is a prime, cross off all its multiples */
			if (integerList.get(i) == true) {
				/* Start at i^2 (e.g. 2^2:4, 3^2: 9, 4^2: 16 */
				for (int j = (int)Math.pow(i,  2); j < n; j += i) {
					integerList.set(j, false);
				}
			}
		}
		
		/* At the end, those marked as true are true primes */
		for (int i = 2; i < n; i++) {
			if (integerList.get(i) == true) {
				primes.add(i);
			}
		}
		
		return primes;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int N = 100;
		List<Integer> primes = getPrimesSieve(N);
		log.info("Num Primes up to {}: {}", N, primes.size());
		for (Integer p : primes) {
			System.out.printf("%d ", p);
		}
		System.out.println("");
	}

}
