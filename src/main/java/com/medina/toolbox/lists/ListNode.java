package com.medina.toolbox.lists;

public class ListNode {

	public int data;
	public ListNode next;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append(data);

		return builder.toString();
	}

}
