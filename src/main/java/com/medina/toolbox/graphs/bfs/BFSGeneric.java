package com.medina.toolbox.graphs.bfs;

import java.io.IOException;

import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.TraversalProceduresGeneric;

public class BFSGeneric {

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
