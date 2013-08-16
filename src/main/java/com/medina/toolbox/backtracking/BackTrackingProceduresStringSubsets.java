package com.medina.toolbox.backtracking;

import java.util.ArrayList;
import java.lang.String;

public class BackTrackingProceduresStringSubsets extends BackTrackingProceduresGeneric {


	@Override
	public <T> boolean isSolution(ArrayList<Integer> a, int k, T input) {
		if (input instanceof Integer) {
			return k == (Integer)input;
		}
		if (input instanceof String) {
			return k == ((java.lang.String)input).length();	
		}
		
		return false;
	}

	@Override
	public <T> void processSolution(ArrayList<Integer> a, int k, T input) {
		
		System.out.printf("{");
		for (int i = 0; i <= k; i++) {
			if (a.get(i) == 1) {
				if (input instanceof Integer) {
					System.out.printf(" %d ", i);
				}
				if ((input instanceof String) && (i < k)) {
					System.out.printf(" %s ", ((java.lang.String)input).charAt(i));
				}
			}
		}
		System.out.printf("}\n");
	}

	@Override
	public <T> int constructCandidates(ArrayList<Integer> a, int k,
			ArrayList<Integer> c, T input) {
		
		int ncandidates = 2;
		c.add(1);
		c.add(0);
		
		return ncandidates;
		
	}

	
	public static void main(String[] args) {
	

	}

}
