package com.algorithmica.search;

import java.util.Queue;

public class TernarySearchTree implements ITrie {

	private TNode root;
	
	@Override
	public void add(String word) {
		if(root==null) root = new TNode();
		if(word.length() > 0)auxAdd(root, word);
	}
	
	private void auxAdd(TNode node,String word){
		char wc = word.charAt(0);
		char c = node.c;
		if(node.c == 0)	node.c = word.charAt(0);
		else if(wc < c){
			//node
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
