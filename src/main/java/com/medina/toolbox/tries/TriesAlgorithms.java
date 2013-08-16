package com.medina.toolbox.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriesAlgorithms {

	private static int NUMOFCHARS = 26;
	

	
	private class TrieNode {
		
		boolean isEnd = false;
		TrieNode[] child;
		List<String> words;
		
		public TrieNode() {
			super();
			child = new TrieNode[26];
			words = new ArrayList<String>();			
		}
		
		
	}

	public TrieNode insertWordIntoTrie(TrieNode node, String word, int index, String origWord) {
				
		if (node == null) {
			node = new TrieNode();
		}
		
		if (index < word.length()) {
			int idx = Integer.valueOf(word.toLowerCase().charAt(index)) - 'a';
			node.child[idx] = insertWordIntoTrie(node.child[idx], word, index + 1, origWord);
		}else {
			if (!node.isEnd) {	
				node.isEnd = true;				
			}
			node.words.add(origWord);
		}
		
		return node;
	}
	
	
	public void printAnagramsTogether(TrieNode node) {
		
		if (node == null) {
			return;
		}
		
		if (node.isEnd) {
			for (String word : node.words) {
				System.out.printf("%s\n", word);
			}
		}
		
		for (int i = 0; i < NUMOFCHARS; i++) {
			printAnagramsTogether(node.child[i]);
		}
		
	}
	
	public String sortString(String s) {
		
		char[] chars = s.toCharArray();
        Arrays.sort(chars);	        
        String sorted = new String(chars);
        
        return sorted;
	}
	
	public void printAnagramsTogetherDriver() {
		
		List<String> words = new ArrayList<String>();
		words.add("god");
		words.add("cat");
		words.add("alberto");
		words.add("act");
		words.add("dog");
		words.add("tac");
		words.add("ogd");		
		words.add("otrebla");
				
		TrieNode root = null;
		for (String word : words) {
			String sortedWord = sortString(word);
			root = insertWordIntoTrie(root, sortedWord, 0, word);
		}
		
		printAnagramsTogether(root);
	}
	

	
	public static void main(String[] args) {

		TriesAlgorithms ta = new TriesAlgorithms();
		ta.printAnagramsTogetherDriver();
	}

}
