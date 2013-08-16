package com.medina.toolbox.backtracking;

import java.util.ArrayList;

public class BackTrackingProceduresSubsets extends BackTrackingProceduresGeneric {


	@Override
	public boolean isSolution(ArrayList<Integer> a, int k, int input) {		
		return k == input;
	}

	@Override
	public void processSolution(ArrayList<Integer> a, int k, int input) {
		
		System.out.printf("{");
		for (int i = 0; i <= k; i++) {
			if (a.get(i) == 1) {
				System.out.printf(" %d ", i);
			}
		}
		System.out.printf("}\n");
	}

	@Override
	public int constructCandidates(ArrayList<Integer> a, int k,
			ArrayList<Integer> c, int input) {
		
		int ncandidates = 2;
		c.add(1);
		c.add(0);
		
		return ncandidates;
		
	}
	
	public static void main(String[] args) {
	

	}

}
