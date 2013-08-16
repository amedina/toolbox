package com.medina.toolbox.backtracking;

import java.util.ArrayList;

public interface BackTrackingProcedures {

	/*
	 * Test to see if the first k elements of the array a form a complete
	 * solution The argument <input> allows the passing of information to this
	 * routine
	 */
	boolean isSolution(ArrayList<Integer> a, int k, ArrayList<Integer> input);
	boolean isSolution(ArrayList<Integer> a, int k, int input);
	<T> boolean isSolution(ArrayList<Integer> a, int k, T input);

	/* Print, count, or do whatever is needed to process a full valid solution */
	void processSolution(ArrayList<Integer> a, int k, ArrayList<Integer> input);
	void processSolution(ArrayList<Integer> a, int k, int input);
	<T> void processSolution(ArrayList<Integer> a, int k, T input);

	/*
	 * Fills the array c with the complete set of possible candidates for
	 * position k of a, given the contents of the first k - 1 positions. The number of candidates
	 * return by this routine can be indicated in the parameter ncandidates
	 */
	int constructCandidates(ArrayList<Integer> a, int k, ArrayList<Integer> c, ArrayList<Integer> input);
	int constructCandidates(ArrayList<Integer> a, int k, ArrayList<Integer> c, int input);
	<T> int constructCandidates(ArrayList<Integer> a, int k, ArrayList<Integer> c, T input);
	/* 
	 * These routines enable hte modification of the data structures in response to the latest move, 
	 * or to clean them up if  backtracking decision was made
	 */
	void makeMove(ArrayList<Integer> a, int k, ArrayList<Integer> input);
	void unmakeMove(ArrayList<Integer> a, int k, ArrayList<Integer> input);
	
	void makeMove(ArrayList<Integer> a, int k, int input);
	void unmakeMove(ArrayList<Integer> a, int k, int input);
	
	<T> void makeMove(ArrayList<Integer> a, int k, T input);
	<T> void unmakeMove(ArrayList<Integer> a, int k, T input);

}
