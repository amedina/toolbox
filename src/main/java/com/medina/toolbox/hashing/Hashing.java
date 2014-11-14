package com.medina.toolbox.hashing;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Hashing {

	/*
	 * Given a set of words, print all the anagrams together;
	 * 
	 * Solution #1: Using hash functions: 
	 * (1) Define a hash function based on the characters of a word; 
	 * (2) For each word, sort it, hash it, and store it in the corresponding hash table bucket; 
	 * (3) At the end, traverse all buckets and print the words in the bucket together.
	 */
	
	public static int NUMOFCHARS = 26;
	
	public static int charBasedHashFunctionOne(String s, int m) {
		
		int h =  0;
		for (int i = 0; i < s.length(); i++) {
			h += Math.pow(NUMOFCHARS,  s.length()) * s.charAt(i);
		}
		
		return h % m;
		
	}
	
	
	public static int charBasedHashFunctionTwo(String s, int m) {
		
		int MULT = 997;
		int h = 0;
				
		for (int i = 0; i < s.length(); i++) {
			h = (h * MULT + s.charAt(i)) % m;
		}
		
		return h % m;
		
	}
	
	public static List<String> getListOfWords() {

		List<String> words = new ArrayList<String>();
		words.add("cat");
		words.add("tac");
		words.add("act");
		words.add("dog");
		words.add("god");
		words.add("ogd");
		words.add("alberto");
		words.add("otrebla");
		words.add("laebrto");
		
		return words;

	}

	public static void charBasedHashFunctioneTest() {
		
		List<String> words = getListOfWords();
		Random a = new Random();
		
		char[] s = "abcdefghijklmnopqrstuvxywz".toCharArray();
		
		int i = 0;
		while (i < 100) {
			String ns = String.valueOf(Math.abs(a.nextInt()));
			int idx = charBasedHashFunctionTwo(ns, 17);
			System.out.printf("W: %s idx: %d\n", ns, idx);
			i += 1;
		}
		
//		for (String word : words) {
//			
//			int idx = charBasedHashFunctionOne(word);
//			System.out.printf("W: %s i: %d\n", word, idx);
//			
//		}
	}

	/* Solution #1: Hash-based */
	public static void printAnagramsTogetherSolutionOne(List<String> words) {
		
		/* Define and initialize HASH TABLE */
		List<ArrayList<String>> hashTable = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < 2 * words.size(); i++) {
			hashTable.add(new ArrayList<String>());
		}
		
		/* Compute the HASH VALUES for each word; insert into HASH TABLE */
		for (int i = 0; i < words.size(); i++) {
			/* Hash Code */
			int idx = charBasedHashFunctionOne(words.get(i), 17);			
			/* Insert in proper BUCKET */
			hashTable.get(idx).add(words.get(i));			
		}
		
		/* Traverse the BUCKETS of the HASH TABLE */
		for (List<String> l : hashTable) {
			for (String word : l) {
				System.out.printf("W: %s\n", word);
			}
		}
	}
	
	public static String sortString(String s) {
		
		char[] chars = s.toCharArray();
        Arrays.sort(chars);	        
        String sorted = new String(chars);
        
        return sorted;
	}
	
	/* Solution #2: sorting-based */	
	public  void printAnagramsTogetherSolutionTwo(List<String> words) {
		
		WordElement[] aux = new WordElement[words.size()];
		
		for (int i = 0; i < words.size(); i++) {			
			String sortedWord = sortString(words.get(i));			
	        WordElement e = new WordElement(i, sortedWord);
			aux[i] = e;
		}
		
		Arrays.sort(aux);
		for (int i = 0; i < aux.length; i++) {
			System.out.println(words.get(aux[i].index));
		}

	}
	
	/*
	 * Solution #3: combination of sorting and a TRIE data structure. A TRIE is
	 * a data structure used as an associative array for data whose keys are
	 * strings.
	 * 
	 * (1) Sort the words to be classified as "joint anagrams"; 
	 * (2) insert each word in the TRIE maintaining a list of
	 * Strings as the value stored at each leaf of the TRIE
	 */
	
	public void printAnagramsTogetherDriver() {
		
		List<String> words = new ArrayList<String>();
		words.add("cat");
		words.add("tac");
		words.add("act");
		words.add("dog");
		words.add("god");
		words.add("ogd");
		words.add("alberto");
		words.add("otrebla");
		
		printAnagramsTogetherSolutionTwo(words);
	}
	
	private class WordElement implements Comparable {
		public int index;
		public String word;
		
		public WordElement(int index, String word) {
			super();
			this.index = index;
			this.word = word;
		}

		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("WordElement [index=");
			builder.append(index);
			builder.append(", word=");
			builder.append(word);
			builder.append("]");
			return builder.toString();
		}


		public int compareTo(Object o) {
			WordElement other = (WordElement)o;
			return word.compareTo(other.word);
		}
	}
	
	public static void main(String[] args) {

		Hashing h = new Hashing();
		
		Hashing.charBasedHashFunctioneTest();
//		List<String> words = Hashing.getListOfWords();
//		System.out.println("Solution #1: Hashing");
//		Hashing.printAnagramsTogetherSolutionOne(words);
//		System.out.println("Solution #2: Sorting");
//		h.printAnagramsTogetherSolutionTwo(words);
		
		

	}

}
