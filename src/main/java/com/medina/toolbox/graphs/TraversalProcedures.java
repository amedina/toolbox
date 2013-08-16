package com.medina.toolbox.graphs;

public interface TraversalProcedures {
	void init(Graph g, GraphTraversal gt);
	boolean processVertexEarly(int v);
	boolean processVertexLate(int v);
	boolean processEdge(int x, int y);	
	void finalize();
}
