package com.medina.toolbox.unionfind;

public class UnionFind {

	/* Number of elements in set */
	int n; 
	/* Parent element for each vertex */
	int[] parent;
	/* Size of subtree rooted at vertex  i */
	int[] size;
	
	
	public UnionFind(int n) {
		
		this.n = n;
		this.parent = new int[n + 1];
		this.size = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		
	}
	
	public void printUnionFIndStructures() {
		
		for (int i = 0; i < n; i++) {
			System.out.printf("parent[%d]: %d\n", i, parent[i]);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.printf("size[%d]: %d\n", i , size[i]);
		}
		
	}
	
	public int find(int i) {
		
		if (parent[i] == i) {
			return i;
		}
		
		return find(parent[i]);
	}
	
	public void union(int i, int j) {
		
		int r1 = find(i);
		int r2 = find(j);
		
		if (r1 == r2) { return;}
		
		if (size[r1] > size[r2]) {
			size[r1] = size[r1] + size[r2];
			parent[r2] = r1;
		}else {
			size[r2] = size[r2] + size[r1];
			parent[r1] = r2;
		}
		
	}
	
	public boolean sameComponent(int s1, int s2) {
		return find(s1) == find(2);
	}

	public static void main(String[] args) {

		UnionFind uf = new UnionFind(7);
		uf.printUnionFIndStructures();
		
	}

}
