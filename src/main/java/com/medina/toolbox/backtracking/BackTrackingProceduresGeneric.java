package com.medina.toolbox.backtracking;

import java.util.ArrayList;

public class BackTrackingProceduresGeneric implements BackTrackingProcedures {

	@Override
	public boolean isSolution(ArrayList<Integer> a, int k, ArrayList<Integer> input) {
		System.out.printf("BackTrackingProceduresGeneric: isSolution: Not implemented!");
		return false;
	}

	@Override
	public boolean isSolution(ArrayList<Integer> a, int k, int input) {
		System.out.printf("BackTrackingProceduresGeneric: isSolution: Not implemented!");
		return false;
	}

	@Override
	public void processSolution(ArrayList<Integer> a, int k, ArrayList<Integer> input) {
		System.out.printf("BackTrackingProceduresGeneric: processSolution: Not implemented!");		
	}
	
	@Override
	public void processSolution(ArrayList<Integer> a, int k, int input) {
		System.out.printf("BackTrackingProceduresGeneric: processSolution: Not implemented!");		
	}

	@Override
	public int constructCandidates(ArrayList<Integer> a, int k, ArrayList<Integer> c, ArrayList<Integer> input) {
		System.out.printf("BackTrackingProceduresGeneric: constructCandidates: Not implemented!");
		return 0;
	}
	public int constructCandidates(ArrayList<Integer> a, int k, ArrayList<Integer> c, int input) {
		System.out.printf("BackTrackingProceduresGeneric: constructCandidates: Not implemented!");
		return 0;
	}

	@Override
	public void makeMove(ArrayList<Integer> a, int k, ArrayList<Integer> input) {
			
	}

	@Override
	public void unmakeMove(ArrayList<Integer> a, int k, ArrayList<Integer> input) {
		
		
	}

	@Override
	public void makeMove(ArrayList<Integer> a, int k, int input) {
	
		
	}

	@Override
	public void unmakeMove(ArrayList<Integer> a, int k, int input) {
	
		
	}

	public static void main(String[] args) {
		

	}

	@Override
	public <T> boolean isSolution(ArrayList<Integer> a, int k, T input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> void processSolution(ArrayList<Integer> a, int k, T input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> int constructCandidates(ArrayList<Integer> a, int k,
			ArrayList<Integer> c, T input) {
		System.out.printf("constructCandidates: Not IMplemented yet!\n");
		return 0;
		
	}

	@Override
	public <T> void makeMove(ArrayList<Integer> a, int k, T input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void unmakeMove(ArrayList<Integer> a, int k, T input) {
		// TODO Auto-generated method stub
		
	}

}
