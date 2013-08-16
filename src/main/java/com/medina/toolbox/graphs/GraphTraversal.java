package com.medina.toolbox.graphs;

public class GraphTraversal {

	public Graph g;
	public TraversalProcedures proc;
	public boolean[] processed;
	public boolean[] discovered;
	public int[] parent;
	
	/* Allow for early termination */
	public boolean finished = false;
	
	public GraphTraversal(Graph g, TraversalProcedures proc) {
		
		this.g = g;
		this.proc = proc;
		this.processed = new boolean[g.getNumVertices()];
		this.discovered = new boolean[g.getNumVertices()];
		this.parent = new int[g.getNumVertices()];
		this.finished = false;
		
		/* Initialize Search */
		for (int i = 0; i < g.getNumVertices(); i++) {
			processed[i] = Boolean.FALSE;
			discovered[i] = Boolean.FALSE;
			parent[i] = -1;
		}
				
	}
	
	
}
