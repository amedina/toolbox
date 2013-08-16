package com.medina.toolbox.graphs;

import java.io.IOException;

/*
 * Starts from a given node, and grows the tree one node at a time, 
 * until all nodes have been included.
 * 
 * PRIM's algorithm is like a SPF algorithm, but the distance associated with 
 * each node corresponds to min-weight incident  edge's weight.
 */
public class MSTPrimAlgorithm {

	public void prim(Graph g, int start) {
		
		boolean[] inTree = new boolean[g.getNumVertices()];
		double[] distance = new double[g.getNumVertices()];
		int[] parent = new int[g.getNumVertices()];
		
		/* Initialize structures */
		for (int i = 0; i < g.getNumVertices(); i++) {
			inTree[i] = Boolean.FALSE;
			distance[i] = Double.MAX_VALUE;
			parent[i] = -1;			
		}
		
		distance[start] = 0;
		
		int x = start;
		
		while (!inTree[x]) {
			
			/* Include selected node in the Tree */
			System.out.printf("Adding TREE Node: %d Weight: %f\n", x, distance[x]);
			inTree[x] = Boolean.TRUE;
			
			/* Assign desirability metric to all neighbors of x (min weight outgoing edge from x) */
			EdgeNode p = g.getEdges(x);
			while (p != null) {
				
				int y = p.y;
				double weight = p.weight;
				
				if (distance[y] > weight && !inTree[y]) {
					distance[y] = weight;
					parent[y] = x;
				}
				
				p = p.next;
				
			}

			/* Pick the most desirable vertex (min-weight) */
			x = 1;
			double dist = Double.MAX_VALUE;
			for (int i = 0; i < g.getNumVertices(); i++) {
				if (!inTree[i] && dist > distance[i]) {
					dist = distance[i];
					x = i;
				}
			}
			
		}
 		
	}
	
	public static void main(String[] args) {
		
		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/MST03.txt");
			g.printGraph();
			
			MSTPrimAlgorithm p = new MSTPrimAlgorithm();
			p.prim(g, 0);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
