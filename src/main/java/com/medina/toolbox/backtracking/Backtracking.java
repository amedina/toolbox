package com.medina.toolbox.backtracking;

import java.util.ArrayList;

public class Backtracking {

	BackTrackingProcedures proc;
	boolean finished = false;
			
	public Backtracking(BackTrackingProcedures proc) {
		this.proc = proc;
	}
	
	public void backtrack(ArrayList<Integer> a, int k, int input) {
		
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		Integer ncandidates = 0;
		
		if (proc.isSolution(candidates, k, input)) {
			proc.processSolution(a, k, input);
		}else {
			k += 1; 
			ncandidates = proc.constructCandidates(a, k, candidates, input);
			for (int i = 0; i < ncandidates; i++) {
				a.set(k, candidates.get(i));
				proc.makeMove(a, k, input);
				backtrack(a, k, input);
				proc.unmakeMove(a, k, input);
				if (finished) {
					return;
				}
			}
			
		}
	}
	
	public <T> void backtrack(ArrayList<Integer> a, int k, T input) {
		
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		Integer ncandidates = 0;
		
		if (proc.isSolution(candidates, k, input)) {
			proc.processSolution(a, k, input);
		}else {
			k += 1; 
			ncandidates = proc.constructCandidates(a, k, candidates, input);
			for (int i = 0; i < ncandidates; i++) {
				a.set(k, candidates.get(i));
				proc.makeMove(a, k, input);
				backtrack(a, k, input);
 				proc.unmakeMove(a, k, input);
				if (finished) {
					return;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
	

	}

}
