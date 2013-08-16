package com.medina.toolbox.graphs;

import java.util.ArrayList;

public class Dijkstra {
	
	Graph g;
	int source;
	int target;

	boolean[] inTree;
	double[] distance;
	int[] parents;
	
	public Dijkstra(Graph g) {	
		inTree = new boolean[g.getNumVertices()];
		distance = new double[g.getNumVertices()];
		parents = new int[g.getNumVertices()];
	}
	
	public void shortestPaths(int s, int t) {
		
		/* Initialize structures */
		for (int i = 0; i < g.getNumVertices(); i++) {
			inTree[i] = Boolean.FALSE;
			distance[i] = Double.MAX_VALUE;
			parents[i] = -1;			
		}
		
		distance[s] = 0;
		int x = s;
		
		while (!inTree[x]) {
			
			inTree[x] = Boolean.TRUE;
			
			/* Assign desirability values to neighbors of x */
			EdgeNode p = g.getEdges(x);
			while (p != null) {
				
				int y = p.y;
				double weight = p.weight;
				
				if (distance[y] > distance[x] + weight) {
					distance[y] = distance[x] + weight;
					parents[y] = x;
				}
				
				p = p.next;			
			}
			
			/* Select vertex with highest desirability (shortest path) */
			double dist = Double.MAX_VALUE;
			for (int i = 0; i < g.getNumVertices(); i++) {
				if (!inTree[i] && distance[i] < dist) {
					dist = distance[i];
					x = i;
				}
			}
		}
		
	}
	
	public void findPaths(int start, int end) {
		
		if (start == end || end  == -1) {

			System.out.printf("\n%d ", start);
		
		}else {
			
			findPaths(start, parents[end]);
			
			System.out.printf("%d ", end);
		}
				
	}
	
	public static void getPath(int start, int end, int[] parents, ArrayList<Integer> path) {
		
		if (start == end || end  == -1) {
			path.add(start);
		}else {
			getPath(start, parents[end], parents, path);
			path.add(end);
		}
				
	}
	
	public static void main(String[] args) {


	}

}
