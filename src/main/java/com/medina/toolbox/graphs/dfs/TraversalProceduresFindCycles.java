package com.medina.toolbox.graphs.dfs;

import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.GraphTraversal;
import com.medina.toolbox.graphs.TraversalProcedures;

public class TraversalProceduresFindCycles implements TraversalProcedures {
	
	private Graph g;
	private GraphTraversal gt;
	
	public void init(Graph g, GraphTraversal gt) {
		this.g = g;
		this.gt = gt;
	}
	
	public boolean processVertexEarly(int v) {  
		return false;
	}
	
	public boolean processVertexLate(int v) {
		return false;
	}
	
	public boolean processEdge(int x, int y) {
	
		System.out.printf("Process edge: (%d,  %d)\n", x, y);
		
		if (gt.discovered[y] && gt.parent[y] != x) {
			System.out.printf("Cycle found from %d to %d!\n", y, x);			
			return true;
		}
		
		return false;
	}
	
	public void finalize() {
		
	}
	
	public static void main(String[] args) {

	}



}
