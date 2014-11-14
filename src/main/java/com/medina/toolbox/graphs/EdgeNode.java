package com.medina.toolbox.graphs;

public class EdgeNode implements Comparable<EdgeNode> {
	
	public int x;
	public int y; 
	public double weight;
	public EdgeNode next;
	
	public EdgeNode() {
		super();
		this.x = -1;
		this.y = -1;
		this.weight = 0.0;
		this.next = null;

	}

	public EdgeNode(int y, int weight, EdgeNode next) {
		super();
		this.x = -1;
		this.y = y;
		this.weight = weight;
		this.next = next;
	}

	public EdgeNode(int x, int y, int weight, EdgeNode next) {
		super();
		this.x = x;
		this.y = y;
		this.weight = weight;
		this.next = next;
	}
	
	public int compareTo(EdgeNode o) {
		
		if (this.weight - o.weight < 0.0001) {
			return 0;
		}
		
		if (this.weight > o.weight) {
			return -1;
		}
		
		return 1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EdgeNode [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", weight=");
		builder.append(weight);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
