package com.algorithmica.search;

import java.util.Queue;

public class Driver {

	public static void main(String[] args) {
		ITrie iTrie = new RWayTrie();
		iTrie.add("Anil");		
		iTrie.add("Animal");		
		iTrie.add("Sunil");
		iTrie.add("Suman");
		iTrie.add("Sushma");
		iTrie.add("Kumari");
		iTrie.add("Arun");
		iTrie.add("Paul");
		iTrie.display();
		boolean contains = iTrie.contains("Aniln");
		System.out.println(contains);
		contains = iTrie.contains("Paul");
		System.out.println(contains);
		Queue<String> acQueue = iTrie.autocomplete("Su");
		System.out.println(acQueue);
		System.out.println(iTrie.size());
		
	}
}
