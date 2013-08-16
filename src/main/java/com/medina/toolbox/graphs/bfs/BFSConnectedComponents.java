package com.medina.toolbox.graphs.bfs;

import java.io.IOException;

import com.medina.toolbox.graphs.Graph;

public class BFSConnectedComponents {

	/*
	 * KEY IDEA: 
	 * 
	 * A Graph Traversal starting from a given node, will traverse all nodes REACHABLE
	 * from the starting node. Therefore, to compute all the CONNECTED COMPONENTS we have to 
	 * SCAN the array of vertices; and for each one, if it has not been discovered in previous traversals,
	 * run a BFS TRAVERSAL with that node as the STARTING POINT. The procedure PROCESS VERTEX EARLY will
	 * print the vertices discovered in each separate traversal as belonging to a separate
	 * connected component
	 */
	
	public static void printConnectedComponents(Graph g) {
		
		TraversalProceduresConnectedComponents proc = new TraversalProceduresConnectedComponents();
		BreadthFirstSearch bfs = new BreadthFirstSearch(g, proc);
		
		int connComponentNum = 0;
		for (int i = 0; i < g.getNumVertices(); i++) {
			if (!bfs.discovered[i]) {
				connComponentNum += 1;
				System.out.printf("Connected component: %d: ", connComponentNum);			
				bfs.traverse(i);
				System.out.println("");
			}
		}
		
	}
	
	public static void main(String[] args) {

		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/GraphTwoConnectedComponents.txt");
			g.printGraph();			
			
			BFSConnectedComponents.printConnectedComponents(g);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

}
