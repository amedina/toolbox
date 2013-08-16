package com.medina.toolbox.tries;

class WordElement implements Comparable {

	public int index;
	public String word;
	
	public WordElement(int index, String word) {
		super();
		this.index = index;
		this.word = word;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordElement [index=");
		builder.append(index);
		builder.append(", word=");
		builder.append(word);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int compareTo(Object o) {
		WordElement other = (WordElement)o;
		return word.compareTo(other.word);
	}
}