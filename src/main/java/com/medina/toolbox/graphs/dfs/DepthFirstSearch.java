package com.medina.toolbox.graphs.dfs;

import java.io.IOException;

import com.medina.toolbox.graphs.EdgeNode;
import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.GraphTraversal;
import com.medina.toolbox.graphs.TraversalProcedures;
import com.medina.toolbox.graphs.TraversalProceduresGeneric;


public class DepthFirstSearch extends GraphTraversal {

	
	/* DFS time tracking */
	private int time = 0;
	public int[] entryTime;
	public int[] exitTime;	
	
	public DepthFirstSearch(Graph g, TraversalProcedures proc) {
		
		super(g, proc);
		
		this.entryTime = new int[g.getNumVertices()];
		this.exitTime = new int[g.getNumVertices()];

	}
	
	public static enum EdgeType {
		TREE,
		BACK,
		FORWARD,
		CROSS,
		UNCLASSIFIED
	}
	
	public EdgeType edgeClassification(int x, int y) {
		
		if (parent[y] == x) {
			return EdgeType.TREE;
		}
		
		if (discovered[y] && !processed[y]) {
			return EdgeType.BACK;
		}
		
		if (processed[y] && entryTime[y] > entryTime[x]) {
			return EdgeType.FORWARD;
		}
		
		if (processed[y] && entryTime[y] < entryTime[x]) {
			return EdgeType.CROSS;
		}		
		
		return EdgeType.UNCLASSIFIED;
	}
	
	public void traverse(int v) {	

		time += 1;		
		discovered[v] = Boolean.TRUE;
		entryTime[v] = time;
		
		proc.processVertexEarly(v);
		
		/* Temporary Edge pointer */
		EdgeNode p = g.getEdges().get(v); 
		while (p != null) {
			
			/* Grab other end point */
			int y = p.y;
			
			if (!discovered[y]) {
				
				/* Update parent relationship */
				parent[y] = v;
				
				finished = proc.processEdge(v, y);
				
				/* Recurse */
				traverse(y);				
				
			}else {
				
				if ((!processed[y] && (parent[v] != y)) || g.isDirected()) {
					finished = proc.processEdge(v, y);
				}
			}
			
			if (finished) {
				return;
			}
			
			p = p.next;
		}
		
		proc.processVertexLate(v);
		
		time += 1;
		exitTime[v] = time;
		
		processed[v] = Boolean.TRUE;
	}
	

	
	public static void main(String[] args) {

		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/graph01.txt");
			g.printGraph();
			
			TraversalProceduresGeneric proc = new TraversalProceduresGeneric();
			DepthFirstSearch bfs = new DepthFirstSearch(g, proc);
			bfs.traverse(0);
			proc.finalize();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
