package com.medina.toolbox.lists;

public class DoublyLinkedListNode {

	public int data;
	public DoublyLinkedListNode prev;
	public DoublyLinkedListNode next;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append(data);

		return builder.toString();
	}

}
