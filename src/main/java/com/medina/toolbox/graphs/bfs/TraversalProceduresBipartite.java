package com.medina.toolbox.graphs.bfs;

import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.GraphTraversal;
import com.medina.toolbox.graphs.TraversalProcedures;

public class TraversalProceduresBipartite implements TraversalProcedures {
	
	public static int UNCOLORED = -1;
	public static int WHITE = 1;
	public static int BLACK = 0;
	public boolean bipartite = true;
	
	public int[] color;
	
	Graph g;
	GraphTraversal gt;
	
	public void init(Graph g, GraphTraversal gt) {
		color = new int[g.getNumVertices()];
		for (int i = 0; i < g.getNumVertices(); i++) {
			color[i] = UNCOLORED;
		}
		
		this.g = g;
		this.gt  = gt;
	}
	
	public boolean processVertexEarly(int v) {  
		return false;
	}
	
	public boolean processVertexLate(int v) {
		return false;
	}
	
	public boolean processEdge(int x, int y) {
		
		if (color[x] == color[y]) {
			bipartite = false;
			System.out.printf("Warning: Graph not bipartite due to violation of (%d, %d)\n", x, y);
			return true;
		}
		
		color[y] = complement(color[x]);
		
		return false;
	}
	
	@Override
	public void finalize() {
		
	}
	
	private int complement(int color) {
		
		if (color == WHITE) { return BLACK; }
		if (color == BLACK) { return WHITE; }
		
		return UNCOLORED;
	}
	
	public static void main(String[] args) {

	}



}
