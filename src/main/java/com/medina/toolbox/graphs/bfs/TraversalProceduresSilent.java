package com.medina.toolbox.graphs.bfs;

import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.GraphTraversal;
import com.medina.toolbox.graphs.TraversalProcedures;

public class TraversalProceduresSilent implements TraversalProcedures {
	
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
		return false;
	}
	
	@Override
	public void finalize() {
		
	}
	
	public static void main(String[] args) {

	}



}
