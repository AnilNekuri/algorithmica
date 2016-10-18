package com.algorithmica.map;

public class ListNode<K,V>{
	public K key;
	public V value;
	public ListNode<K,V> next;
	@SuppressWarnings("unchecked")
	public ListNode(){
		key = null;
		value = (V)new Object();
		next = null;
	}
	
	public ListNode(K key,V value) {
		this.key = key;
		this.value = value;
		next = null;
	}		
}