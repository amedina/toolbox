package com.medina.toolbox.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medina.toolbox.bits.BitManipulation;

public class PowerSet {

	private static Logger log = LoggerFactory.getLogger(PowerSet.class);
	
	private BitManipulation bp;
	
	public PowerSet() {
		bp = new BitManipulation();
	}
	
	/*
		Remove {1}, and execute powerset for {2, 3};
			Remove {2}, and execute powerset for {3};
				Remove {3}, and execute powerset for {};
					Powerset of {} is {{}};
				Powerset of {3} is 3 combined with {{}} = { {}, {3} };
			Powerset of {2, 3} is {2} combined with { {}, {3} } = { {}, {3}, {2}, {2, 3} };
		Powerset of {1, 2, 3} is {1} combined with { {}, {3}, {2}, {2, 3} } = { {}, {3}, {2}, {2, 3}, {1}, {3, 1}, {2, 1}, {2, 3, 1} }.
	*/
	
	public static Set<Set<Integer>> powerSetRecursiveMethodOnSet(Set<Integer> originalSet) {
		
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        
        if (originalSet.isEmpty()) {
            sets.add(originalSet);
            return sets;
        }
        
        /* Create list with elements of Original Set */
        List<Integer> list = new ArrayList<Integer>(originalSet);
        
        /* Grab first element in original set */
        Integer head = list.get(0);
        
        /* RECURSION: Take "rest" of set (without the head), and call powerSet recursively */
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        
        /* Recursive call to powerSet */
        for (Set<Integer> set : powerSetRecursiveMethodOnSet(rest)) {
            
        	Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        
        }
        return sets;
    }
	
	public static Set<List<Integer>> powerSetRecursiveOnList(List<Integer> originalSet) {
		
        Set<List<Integer>> sets = new HashSet<List<Integer>>();
        
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<Integer>());
            return sets;
        }
        
        /* Grab first element in original set */
        Integer head = originalSet.get(0);
        
        /* RECURSION: Take "rest" of set (without the head), and call powerSet recursively */
        List<Integer> rest = new ArrayList<Integer>(originalSet.subList(1, originalSet.size()));
        
        /* Recursive call to powerSet */
        for (List<Integer> set : powerSetRecursiveOnList(rest)) {
        	set.add(head);
            sets.add(set);        
        }
        return sets;
	}
	
	private static Set<Set<Integer>> powerSetMethodTwo(List<Integer> list) {

		int numOfSubsets = 1 << list.size();
		Set<Set<Integer>> subSets = new HashSet<Set<Integer>>();
		
		for (int i = 0; i < numOfSubsets; i++) {
			
			int pos = 0;
			int bitmask = i;

			Set<Integer> subset = new HashSet<Integer>();
			
			while (bitmask > 0) {
				if ((bitmask & 1) == 1) {
					subset.add(list.get(pos));
				}
				bitmask >>= 1;
				pos++;
			}
			
			subSets.add(subset);

		}
		
		return subSets;
	}
	
	
	private static char[] alphabet = {'0', '1'};
	private static void powerSetRecursiveMethodThree(List<String> list, String perm, int index, int n) {
		
		if (index == n) {
			printSet(perm, list); 
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			String temp = perm;
			perm += alphabet[i];
			powerSetRecursiveMethodThree(list, perm, index + 1, n);
			perm = temp;
		}
		
	}

	public static void printSet(String perm, List<String> list) {
		
		String set = "{ ";
		for (int i = 0; i < perm.length(); i++) {
			int val = Integer.valueOf(perm.charAt(i)) - '0';
			if (val == 1) {
				set += list.get(i) + " ";				
			}
		}
		set += "}";
		
		System.out.println(set);
		
	}
	
	public static void main(String[] args) {		
		
		/* Define set */
		Set<Integer> set = new HashSet<Integer>();		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		Set<String> setTwo = new HashSet<String>();
		setTwo.add("1");
		setTwo.add("2");
		setTwo.add("3");
		setTwo.add("4");
		
		//Set<Set<Integer>> sets = PowerSet.powerSet(set);
		
/*********************** RECURSIVE APPROACH ***************************/			
		List<Integer> list = new ArrayList<Integer>(set);
		Set<List<Integer>> subSetsRecursiveOnList = PowerSet.powerSetRecursiveOnList(list);
		System.out.println(subSetsRecursiveOnList);
/*********************************************************************/
		
/*********************** BITMASK APPROACH *****************************/
		List<String> listTwo = new ArrayList<String>(setTwo);
		Set<Set<Integer>> subSets = PowerSet.powerSetMethodTwo(list);
		System.out.println(subSets);
/*********************************************************************/


	}



}
