package com.medina.toolbox.trees;

public class Interval {
	
	private int left;
	private int right;
	
	public Interval(int l, int r) {
		this.left = l;
		this.right = r;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Interval [left=" + left + ", right=" + right + "]";
	}

}
