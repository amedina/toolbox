package com.medina.toolbox.graphs.dfs;

import java.util.Stack;

import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.GraphTraversal;
import com.medina.toolbox.graphs.TraversalProcedures;

public class TraversalProceduresTopologicalSorting implements TraversalProcedures {
	
	private Graph g;
	private GraphTraversal gt;	
	public Stack<Integer> s;
	
	/* Specific to this TraversalProcedures imeplementation */
	private DepthFirstSearch dfs = null;
	
	@Override
	public void init(Graph g, GraphTraversal gt) {
		this.g = g;
		this.gt = gt;		
		this.dfs = (DepthFirstSearch)gt;
		this.s = new Stack<Integer>();
	}
	
	@Override
	public boolean processVertexEarly(int v) {  
		return false;
	}
	
	@Override
	public boolean processVertexLate(int v) {
		s.push(v);
		return false;
	}
	
	@Override
	public boolean processEdge(int x, int y) {
		 processEdge(x, y, dfs);
		 return false;
	}

	public boolean processEdge(int x, int y, DepthFirstSearch dfs) {
		
		DepthFirstSearch.EdgeType edgeClass = dfs.edgeClassification(x, y);
		
		if (edgeClass == DepthFirstSearch.EdgeType.BACK) {
			System.out.printf("Cycle FOUND! Not a DAG!\n");
			return true;
		}
		
		return false;
	}
	
	public void printTopologicalSorting() {
		while (!s.empty()) {
			int v = s.pop();
			System.out.printf("%d ", v);
		}
		System.out.println("");
	}
	
	@Override
	public void finalize() {
		System.out.printf("Topological sorting:\n");
		printTopologicalSorting();
	}
	
	public static void main(String[] args) {

	}



}
