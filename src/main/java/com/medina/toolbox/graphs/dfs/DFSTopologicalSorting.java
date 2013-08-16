package com.medina.toolbox.graphs.dfs;

import java.io.IOException;

import com.medina.toolbox.graphs.Graph;

/*
 * Topological Sorting: orders the vertices of a DAG so that all the 
 * edges go from left to right. It given an ordering to the process each 
 * vertex before any of its successors.
 * 
 * Can be performed efficiently using DFS: LABEL VERTICES in the reverse 
 * ORDER in which they are MARKED as PROCESSED
 * 
 * If during the process, a BACK EDGE is found (a cycle), the procedure would 
 * stop
 */
public class DFSTopologicalSorting {

	public static void main(String[] args) {

		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/DAG01.txt");
			g.printGraph();
			
			TraversalProceduresTopologicalSorting proc = new TraversalProceduresTopologicalSorting();
			DepthFirstSearch dfs = new DepthFirstSearch(g, proc);
			proc.init(g, dfs);
			for (int i = 0; i < g.getNumVertices(); i++) {
				 if (!dfs.discovered[i]) {
					 dfs.traverse(i);
				 }
			}
			
			proc.finalize();
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
