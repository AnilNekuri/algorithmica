package com.algorithmica.search;

import java.util.Queue;

public interface ITrie {
	void add(String word);
	boolean remove(String word);
	boolean contains(String word);
	boolean containsWildCard(String word);	
	Queue<String> autocomplete(String prefix);
	void display();
	int size();	
}
