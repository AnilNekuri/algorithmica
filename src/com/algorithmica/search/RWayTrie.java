package com.algorithmica.search;

import java.util.Queue;

public class RWayTrie implements ITrie{

	RWayNode root = null; 
	
	public RWayTrie(){
		root = new RWayNode();
	}
	
	@Override
	public void add(String word) {
		
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
