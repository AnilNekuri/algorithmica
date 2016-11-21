package com.algorithmica.search;

import java.util.Queue;

public class RWayTrie implements ITrie{

	RWayNode root = null; 
	
	public static void main(String[] args) {
		ITrie iTrie = new RWayTrie();
		iTrie.add("Anil");
		boolean contains = iTrie.contains("anil");
		System.out.println(contains);
	}
	
	public RWayTrie(){
		root = new RWayNode();
	}
	
	@Override
	public void add(String word) {
		if(word.length() > 0){
			auxAdd(null,word.toLowerCase());	
		}
		
//		for(int i = 0; i < word.length(); i++){
//			char c = word.charAt(i);				
//			int ic = (int)c;
//			if(ic == 0){
//				this.root = 
//			}
//			word.charAt(i);
//		}
	}

	public void auxAdd(RWayNode root,String word) {
		RWayChar rwChar = null;
		if(word.length() > 0){
			char c = word.charAt(0);				
			int i = (int)c;
			if(i >= 97 && i <= 122){
				if(root == null) root = this.root;
				rwChar = new RWayChar();
				rwChar.exist = true;				
				root.rwChars[i%97] = rwChar;
			}			
		}
		if(word.length() > 1){
			rwChar.rwNode = new RWayNode();
			auxAdd(rwChar.rwNode,word.substring(1));
		}else{
			rwChar.isWord = true;
		}		
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String word) {		
		return auxContains(null, word);
	}
	
	public boolean auxContains(RWayNode root,String word) {
		if(word.length() > 0){
			if(root == null) root = this.root;
			RWayChar rwChar = null;
			char c = word.charAt(0);				
			int i = (int)c;
			if(i >= 97 && i <= 122){						
				rwChar = root.rwChars[i%97];							
				if(rwChar!= null && rwChar.exist){
					if(word.length() > 1)
						return auxContains(rwChar.rwNode, word.substring(1));
				}else{
						return false;
				}
				if(rwChar.isWord){
					return true;
				}else{
					return false;
				}
			}			
		}
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
