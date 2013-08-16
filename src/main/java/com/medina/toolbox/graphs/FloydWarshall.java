package com.medina.toolbox.graphs;

import java.io.IOException;
import java.util.ArrayList;


/*
 * FLOYD-WARSHALL ALGORITHM
 * 
 * A graph analysis algorithm for finding shortest paths in a weighted graph with positive 
 * or negative edge weights (but with no negative cycles, see below) and also for finding 
 * transitive closure of a relation R. 
 * 
 * A single execution of the algorithm will find the lengths (summed weights) of the shortest 
 * paths between all pairs of vertices, though it does not return details of the paths themselves.
 * 
 */
public class FloydWarshall {

	Graph g;
	ArrayList<ArrayList<Double>> weight;
	int nVertices;
	
	public FloydWarshall(Graph g) {
	
		this.g = g;
		
		weight = new ArrayList<ArrayList<Double>>(g.getNumVertices());
		for (int i = 0; i < g.getNumVertices(); i++) {
			weight.set(i, new ArrayList<Double>());
		}
		
		for (int i = 0; i < g.getNumVertices(); i++) {
			
			EdgeNode p = g.getEdges(i);
			
			while (p != null) {
				int x = p.x;
				int y = p.y;				
				weight.get(x).set(y, p.weight);
			}
		}
		
	}
	
	public void floydWarshall() {
		
		for (int k = 0; k < g.getNumVertices(); k++) {
			for (int i = 0; i < g.getNumVertices(); i++) {
				for (int j = 0; j < g.getNumVertices(); j++) {
					
					double throughK =  weight.get(i).get(k) + weight.get(k).get(j);
					if (throughK < weight.get(i).get(j)) {
						weight.get(i).set(j, throughK);
					}
				}
			}
		}
		
	}
	
	public double getPathCost(int s, int t) {
		
		if (s >= 0 && s < g.getNumVertices() && s >= 0 && s < g.getNumVertices()) {
			System.out.printf("PATH COST S: %d T: %d C: %f\n", s, t, weight.get(s).get(t));
			return weight.get(s).get(t);
		}else {
			return -1;
		}
		
	}
	
	public void printCostMatrix() {
		
		for (int i = 0; i < g.getNumVertices(); i++) {
			for (int j = 0; j < g.getNumVertices(); j++) {
				System.out.printf("M[%d][%d]: %f\n", i, j, weight.get(i).get(j));
			}
		}
	}
	
	
	public static void main(String[] args) {

		Graph g = null;
		try {
			
			g = Graph.readFromFile("data/MST03.txt");
			g.printGraph();
			
			FloydWarshall fw = new FloydWarshall(g);
			fw.printCostMatrix();
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
