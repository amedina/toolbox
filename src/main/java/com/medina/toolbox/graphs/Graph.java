package com.medina.toolbox.graphs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<EdgeNode> edges;
	private List<Integer> degree;
	private int numVertices;
	private int numEdges;
	private boolean directed;
	
	public Graph(int size, boolean directed) {
		super();		
		edges = new ArrayList<EdgeNode>(size);
		for (int i = 0; i < size; i++) {
			edges.add(null);
		}
		degree = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			degree.add(0);
		}
		this.directed = directed;
		this.numVertices = size;
		this.numEdges = 0;
	}

	public List<EdgeNode> getEdges() {
		return edges;
	}

	public void setEdges(List<EdgeNode> edges) {
		this.edges = edges;
	}

	public List<Integer> getDegree() {
		return degree;
	}

	public void setDegree(List<Integer> degree) {
		this.degree = degree;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int nVertices) {
		this.numVertices = nVertices;
	}

	public int getNumEdges() {
		return numEdges;
	}

	public void setNumEdges(int nEdges) {
		this.numEdges = nEdges;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}
	
	public EdgeNode getEdges(int i) {
		if (i < edges.size()) {
			return edges.get(i);
		}
		return null;
	}
	
	public Integer getDegree(int v) {
		if (v < degree.size()) {
			return degree.get(v);
		}
		return -1;
	}
	

	public void incDegree(int x) {
		if (x < degree.size()) {
			degree.set(x, degree.get(x) + 1);
		}
	}	

	
	public void insertEdge(int x, int y, double weight, boolean directed) throws IllegalArgumentException {
		
		if (x < 0 || x >= numVertices || y < 0 || y >= numVertices) {
			throw new IllegalArgumentException();
		}
		
		EdgeNode p = new EdgeNode();
		p.weight = 0.0;
		p.x = x;
		p.y = y;
		p.weight = weight;
		p.next = getEdges(x);
		this.edges.set(x, p);   // Insert at front of adjacency list of node x
		this.incDegree(x);
		
		/*
		 * If graph is not directed, insert edge (y,x) Insert it with 
		 * directed == true, to insert it only once and update the number of edges
		 * only by one too
		 */
		if (!directed) {
			insertEdge(y, x, weight, true);
		}else {
			this.numEdges += 1;
		}
		
	}
	
	public void printGraph() {
	
		EdgeNode p = null;
		
		for (int i = 0; i < numVertices; i++) {
			
			System.out.printf("%d: ", i);
			
			p = edges.get(i);
			while (p != null) {
				System.out.printf(" %d", p.y);
				p = p.next;
			}
			System.out.println("");
		}
	}
	
	public static Graph readFromFile(String fileName) throws IOException {
		 
		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String s = null;
		
		/* Read first graph definition info */
		s = br.readLine();
		String[] fields = s.split(" ");
		int size = Integer.valueOf(fields[0]);
		boolean directed = Boolean.valueOf(fields[1]);
		
		/* Create Graph */
		Graph g = new Graph(size, directed);
		
		/* Read adjacencies in */
		/* Each line must have the form: <source, dest, weight> */		
		s = br.readLine();
		while (s != null) {
			fields = s.split(" ");
			g.insertEdge(Integer.valueOf(fields[0]), Integer.valueOf(fields[1]), Double.valueOf(fields[2]), directed);
			s = br.readLine();
		}
		br.close();
		
		return g;
	}
	
	public static void main(String[] args) {
		
		Graph g = null;
		try {
			g = Graph.readFromFile("data/MST01.txt");
			g.printGraph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
