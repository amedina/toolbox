package com.medina.toolbox.graphs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.medina.toolbox.graphs.bfs.BFSFindPaths;
import com.medina.toolbox.graphs.bfs.BreadthFirstSearch;
import com.medina.toolbox.graphs.bfs.TraversalProceduresSilent;

public class GraphMaze {

	int size;
	Coordinate start;
	Coordinate end;
	ArrayList<ArrayList<Coordinate>> maze;
	Graph mazeGraph;

	public GraphMaze() {		
	
	}	
	
	public void init(int size) {
		
		this.size = size;
		
		maze = new ArrayList<ArrayList<Coordinate>>();
		for (int i = 0; i < size; i++) {
			maze.add(new ArrayList<Coordinate>());
			for (int j = 0; j < size; j++) {
				maze.get(i).add(null);
			}
		}
				
	}
	
	public boolean isFeasible(Coordinate c) {
		
		boolean validI = c.i >= 0 && c.i < size;
		boolean validJ = c.j >= 0 && c.j < size;
		
		boolean validCell = false;
		if (validI && validJ) {
			validCell = (maze.get(c.i).get(c.j).val == 0);
		}
		
		return validI && validJ && validCell;
	}
	
	public Graph createMazeGraph() {
		
		Graph g = new Graph(size * size, Boolean.TRUE);
		
		int count = 0;
		int eCount = 0;
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				System.out.printf("Processing vertex: %d\n", count++);
				Coordinate c = maze.get(i).get(j);
				
				/* Neighbors */
				Coordinate c_1 = new Coordinate(i + 1, j, 0);
				Coordinate c_2 = new Coordinate(i, j + 1, 0);
				Coordinate c_3 = new Coordinate(i- 1, j, 0);
				Coordinate c_4 = new Coordinate(i, j - 1, 0);
				
				if (isFeasible(c)) {
					
					int x = c.i * size + c.j;
					
					if (isFeasible(c_1) && c_1.compareTo(c) != 0) {
						
						int y = (i + 1) * size + j; 
						System.out.printf("Adding edge: %d (%d, %d)\n",  eCount++, x, y);
						g.insertEdge(x, y, 1.0, Boolean.TRUE);
					}
					if (isFeasible(c_2) && c_2.compareTo(c) != 0) {
						int y = i * size + j + 1;
						System.out.printf("Adding edge: %d (%d, %d)\n",  eCount++, x, y);						
						g.insertEdge(x, y,  1.0, Boolean.TRUE);
					}
					if (isFeasible(c_3) && c_3.compareTo(c) != 0) {
						
						int y = (i - 1) * size + j;
						System.out.printf("Adding edge: %d (%d, %d)\n",  eCount++, x, y);
						g.insertEdge(x, y,  1.0, Boolean.TRUE);
					}
					if (isFeasible(c_4) && c_4.compareTo(c) != 0) {

						int y = i * size + j - 1;
						System.out.printf("Adding edge: %d (%d, %d)\n",  eCount++, x, y);
						g.insertEdge(x, y,  1.0, Boolean.TRUE);
					}
				}						
			}
		}
			
		this.mazeGraph = g;
		return g;
	}
	
	
	public ArrayList<Coordinate> searchMaze() {
		
		TraversalProceduresSilent proc = new TraversalProceduresSilent();
		BreadthFirstSearch bfs = new BreadthFirstSearch(mazeGraph, proc);
		
		int startVertex = start.i * size + start.j;
		bfs.traverse(startVertex);

		int endVertex = end.i * size + end.j;
		ArrayList<Integer> path = new ArrayList<Integer>();
		BFSFindPaths.getPath(startVertex, endVertex, bfs.parent, path);
		
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.printf("%d ", path.get(i));
		}
		System.out.printf("\n");
		
		for (int i = 0; i < path.size(); i++) {
			System.out.printf("%d ", path.get(i));
		}
		System.out.printf("\n");
		
		return null;
	}
	
	public void readFromFile(String fileName) throws IOException {
		
		FileInputStream fis = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		String s = null;
		
		/* Read first graph definition info */
		s = br.readLine();
		int size = Integer.valueOf(s);
		
		/* Initialize Maze structure */
		init(size);
		
		/* Create Graph */
		int i = 0;
		s = br.readLine();		
		while (s != null) {
			

			String[] fields = s.split(" ");
			
			for (int j = 0; j < size; j++) {
				
				Coordinate c = new Coordinate(i,j, 0);
			
				if (fields[j].compareTo("S") == 0) {
					start = new Coordinate(i,j, 0);					
				}else {
					if (fields[j].compareTo("E") == 0) {
						end = c;
					}else {
						c.val = Integer.valueOf(fields[j]);
					}
				}								
				maze.get(i).set(j,c);
			}			
			s = br.readLine();
			i++;
		}
		
		br.close();
		
		
	}
	
	public void printMaze() {
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {			
				System.out.printf("%d ", maze.get(i).get(j).val);
			}
			System.out.printf("\n");
		}
	}
	
	public class Coordinate implements Comparable<Coordinate> {
		
		public int i;
		public int j;
		public int val;
		
		public Coordinate(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;			
		}
				
		public int compareTo(Coordinate other) {
			
			if ((this.i == other.i) && (this.j == other.j)) {
				return 0;
			}
			if (this.i > other.i){ return 1;}
			
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		GraphMaze gm = new GraphMaze();
		gm.readFromFile("data/maze04.txt");
		gm.printMaze();
		
		Graph g = gm.createMazeGraph();
		g.printGraph();
		
		gm.searchMaze();
		
		
	}

}
