package com.medina.toolbox.graphs.dfs;

import java.io.IOException;

import com.medina.toolbox.graphs.Graph;
import com.medina.toolbox.graphs.bfs.BreadthFirstSearch;

public class DFSFindCycles {

	public static void main(String[] args) {

		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/graph01.txt");
			g.printGraph();
			
			TraversalProceduresFindCycles proc = new TraversalProceduresFindCycles();			
			BreadthFirstSearch bfs = new BreadthFirstSearch(g, proc);
			
			proc.init(g, bfs);
			bfs.traverse(0);
			proc.finalize();
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
