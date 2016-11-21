package com.algorithmica.search;

import java.util.Queue;

public class RWayTrie implements ITrie{

	RWayNode root = null; 
	
	public static void main(String[] args) {
		ITrie iTrie = new RWayTrie();
		iTrie.add("AZ");
	}
	
	public RWayTrie(){
		root = new RWayNode();
	}
	
	@Override
	public void add(String word) {
		if(word.length() > 0){
			auxAdd(word.toLowerCase());	
		}
	}

	public void auxAdd(String word) {
		if(word.length() > 0){
			char c = word.charAt(0);	
			int i = (int)c;
			if(i >= 97 && i < 122){
				
			}
			System.out.println((int)c);
			
		}
		if(word.length() > 1){
			auxAdd(word.substring(1));
		}		
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsWildCard(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Queue<String> autocomplete(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
