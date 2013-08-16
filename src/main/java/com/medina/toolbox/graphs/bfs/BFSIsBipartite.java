package com.medina.toolbox.graphs.bfs;

import java.io.IOException;

import com.medina.toolbox.graphs.Graph;


/* KEY IDEA:
 * 
 * Model this problem as a TWO-COLOR Graph COLORING problem
 * A graph is BIPARTITE if it CAN BE COLORED WITH TWO COLORS.
 * 
 * Initially, all nodes are UNCOLORED. We scan the vertices array, and for each one,
 * run a BFS TRAVERSAL; the START node is COLORED as WHITE; the PROCESS EDGE EARLY FUNCTION,
 * checks if the target vertex for each processed edge has the same color as the source 
 * vertex; if so, return GRAPH IS NOT BIPARTITE. Otherwise, COLOR the TARGET NODE with
 * the COMPLEMENT color of the source node.
 */

public class BFSIsBipartite {

	public static void check(Graph g) {
		
		TraversalProceduresBipartite proc = new TraversalProceduresBipartite();
		BreadthFirstSearch bfs = new BreadthFirstSearch(g, proc);
		
		proc.init(g, bfs);
		
		for (int i = 0; i < g.getNumVertices(); i++) {
			if (!bfs.discovered[i]) {
				proc.color[i] = proc.WHITE;
				bfs.traverse(i);				
			}
		}
		
		if (proc.bipartite) {
			System.out.printf("Graph IS BIPARTITE!\n");
		}
		
	}

	public static void main(String[] args) {

		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/GraphBipartite.txt");			
			g.printGraph();
			
			BFSIsBipartite.check(g);
			
			g = Graph.readFromFile("data/graph01.txt");
			g.printGraph();
			
			BFSIsBipartite.check(g);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
