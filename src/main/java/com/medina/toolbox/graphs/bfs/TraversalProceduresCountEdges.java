package com.medina.toolbox.graphs.bfs;

import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.GraphTraversal;
import com.medina.toolbox.graphs.TraversalProcedures;

public class TraversalProceduresCountEdges implements TraversalProcedures {
	
	private int numEdges = 0;
	private Graph g;
	private GraphTraversal gt;
	
	@Override
	public void init(Graph g, GraphTraversal gt) {
		this.g = g;
		this.gt = gt;
	}
	
	@Override
	public boolean processVertexEarly(int v) {  
		return false;
	}
	
	@Override
	public boolean processVertexLate(int v) {
		return false;
	}
	
	@Override
	public boolean processEdge(int x, int y) {
		numEdges += 1;
		return false;
	}
	
	@Override
	public void finalize() {
		System.out.println("Number of edges: " + numEdges);
	}
	
	public static void main(String[] args) {

	}



}
