package com.algorithmica.lists;

public class DListNode<K,V> {

	public K key;
	public V data;
	public DListNode<K,V> prev;
	public DListNode<K,V> next;
	@SuppressWarnings("unchecked")
	public DListNode(K k,V v) {
		key = k;
		data = v;
		prev = null;
		next = null;
	}		

}
