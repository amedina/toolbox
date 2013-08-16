package com.medina.toolbox.graphs;

public class TraversalProceduresGeneric implements TraversalProcedures {
	
	private Graph g;
	private GraphTraversal gt;
	
	@Override
	public void init(Graph g, GraphTraversal gt) {
		this.g = g;
		this.gt = gt;
	}

	@Override
	public boolean processVertexEarly(int v) {  
		System.out.printf("Process vertex early: %d\n", v);
		return false;
	}
	
	@Override
	public boolean processVertexLate(int v) {
		System.out.printf("Process vertex late: %d\n", v);
		return false;
	}
	
	@Override
	public boolean processEdge(int x, int y) {
		System.out.printf("Process edge: (%d,  %d)\n", x, y);
		return false;
	}
	
	@Override
	public void finalize() {
		System.out.println("Finalizing BFS...");
	}
	
	public static void main(String[] args) {

	}


}
