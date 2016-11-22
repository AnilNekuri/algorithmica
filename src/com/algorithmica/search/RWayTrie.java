package com.algorithmica.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	}

	public void auxAdd(RWayNode root,String word) {
		RWayChar rwChar = null;
		if(word.length() > 0){
			char c = word.charAt(0);				
			int i = (int)c;
			if(i >= 97 && i <= 122){
				if(root == null) root = this.root;
				rwChar = root.rwChars[i%97];
				if(rwChar == null){
					rwChar = new RWayChar();
				}							
				root.rwChars[i%97] = rwChar;
			}			
		}
		if(word.length() > 1){
			if(rwChar.rwNode == null)
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
		return auxContains(root, word.toLowerCase());
	}
	
	public boolean auxContains(RWayNode root,String word) {
		if(word.length() > 0 && root != null){
			RWayChar rwChar = null;
			char c = word.charAt(0);				
			int i = (int)c;
			if(i >= 97 && i <= 122){						
				rwChar = root.rwChars[i%97];							
				if(rwChar!= null){
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
		prefix = prefix.toLowerCase();
		RWayNode node = root;
		Queue<String> words = new LinkedList<String>();
		boolean isWord = false;
		for(char ch :prefix.toCharArray()){
			int ic = (int)ch;
			RWayChar rWayChar = node.rwChars[ic%97];
			if(rWayChar == null){
				node = null;
				isWord = false;
				break;				
			}		
			node = rWayChar.rwNode;	
			isWord = rWayChar.isWord;
		}
		if(isWord) words.add(prefix);
		if(node != null) auxDiplay(prefix, node, words);
		return words;
	}
	
	private void auxDiplay(String prefix,RWayNode node,final Queue<String> words){
		if(node == null)
			return;
		for(int i = 0; i < node.rwChars.length; i++){
			RWayChar rWayChar = node.rwChars[i];
			if(rWayChar != null){
				String tPrefix = prefix+(char)(97+i);
				if(rWayChar.isWord)
					words.add(tPrefix);
				
				auxDiplay(tPrefix, rWayChar.rwNode, words);					
			}
		}
	}

	@Override
	public void display() {
		Queue<String> words = new LinkedList<String>();
		auxDiplay("", root, words);
		System.out.println(words);
	}

	@Override
	public int size() {
		Queue<String> words = new LinkedList<String>();
		auxDiplay("", root, words);
		return words.size();
	}

}
