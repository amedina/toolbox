package com.medina.toolbox.graphs.bfs;

import java.io.IOException;
import java.util.ArrayList;

import com.medina.toolbox.graphs.Graph;

public class BFSFindPaths {

	public static void findPaths(int start, int end, int[] parents) {
		
		if (start == end || end  == -1) {
			System.out.printf("\n%d ", start);
		}else {
			findPaths(start, parents[end], parents);
			System.out.printf("%d ", end);
		}
				
	}
	
	public static void getPath(int start, int end, int[] parents, ArrayList<Integer> path) {
		
		if (start == end || end  == -1) {
			System.out.printf("\n%d ", start);
			path.add(start);
		}else {
			findPaths(start, parents[end], parents);
			path.add(end);
		}
				
	}

	public static void main(String[] args) {
		
		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/graph01.txt");
			g.printGraph();
			TraversalProceduresSilent proc = new TraversalProceduresSilent();
			BreadthFirstSearch bfs = new BreadthFirstSearch(g, proc);
			
			proc.init(g, bfs);
			bfs.traverse(0);
			
			BFSFindPaths.findPaths(0, 1, bfs.parent);
			BFSFindPaths.findPaths(0, 2, bfs.parent);
			BFSFindPaths.findPaths(0, 3, bfs.parent);
			BFSFindPaths.findPaths(0, 4, bfs.parent);
			BFSFindPaths.findPaths(0, 5, bfs.parent);
			
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
