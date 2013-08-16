package com.medina.toolbox.graphs.bfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.medina.toolbox.graphs.EdgeNode;
import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.GraphTraversal;
import com.medina.toolbox.graphs.TraversalProcedures;
import com.medina.toolbox.graphs.TraversalProceduresGeneric;

public class BreadthFirstSearch extends GraphTraversal  {

	public BreadthFirstSearch(Graph g, TraversalProcedures proc) {
		super(g, proc);
	}
	
	public void traverse(int start) {	

		/* Queue to keep track of work to be done */
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		discovered[start] = Boolean.TRUE;
		
		while (!q.isEmpty()) {
			
			int v = q.remove();
			
			/* Invoke PROCESS VERTEX EARLY functionality */
			proc.processVertexEarly(v);
			
			/* Mark vertex v as processed */
			processed[v] = Boolean.TRUE;
			
			/* Grab adjacency list for node v */
			EdgeNode p = g.getEdges().get(v);
			
			/* Explore all adjacencies of vertex v */
			while (p != null) {
				
				int y = p.y;
				
				if (!processed[y] || g.isDirected()) {
					proc.processEdge(v, y);
				}
				
				if (!discovered[y]) {
					q.add(y);
					discovered[y] = Boolean.TRUE;
					parent[y] = v;
				}
				
				p = p.next;
				
			}
			
			proc.processVertexLate(v);
		}
		
	}
	
	
	public static void main(String[] args) {

		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/graph01.txt");
			g.printGraph();
			
			TraversalProceduresGeneric proc = new TraversalProceduresGeneric();
			BreadthFirstSearch bfs = new BreadthFirstSearch(g, proc);
			bfs.traverse(0);
			proc.finalize();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
