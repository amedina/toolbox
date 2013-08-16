package com.medina.toolbox.graphs;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

import com.medina.toolbox.unionfind.UnionFind;

public class MSTKruskalAlgorithm {

	int n;
	UnionFind uf;
	PriorityQueue<EdgeNode> edges;
	
	public MSTKruskalAlgorithm(Graph g) {

		this.n = g.getNumVertices();
		this.uf = new UnionFind(g.getNumVertices());
		this.edges = new PriorityQueue<EdgeNode>();
		
		List<EdgeNode> graphEdges = g.getEdges();
		for (EdgeNode e : graphEdges) {
			EdgeNode p = e;
			while (p != null) {
				edges.add(p);
				p = p.next;
				System.out.printf("TOP: %s\n", edges.peek());
			}
		}		
		
	}
	public void kruskal() {

		int count = 0;
		
		while (count < n - 1) {
			
			EdgeNode e = edges.remove();
			
			int c1 = uf.find(e.x);
			int c2 = uf.find(e.y);
			
			if (c1 != c2) {
				System.out.printf("Adding edge to Kruskal's MST: %s\n", e.toString());
				uf.union(c1, c2);
			}
			
			count += 1;
		}
 		
		uf.printUnionFIndStructures();
		
	}
	
	public static void main(String[] args) {
		
		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/MST03.txt");
			g.printGraph();
			
			MSTKruskalAlgorithm p = new MSTKruskalAlgorithm(g);
			p.kruskal();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
