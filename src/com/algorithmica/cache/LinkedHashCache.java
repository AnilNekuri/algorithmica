package com.algorithmica.cache;

import com.algorithmica.lists.DLinkedList;
import com.algorithmica.lists.DListNode;
import com.algorithmica.map.HashMap;
import com.algorithmica.map.IMap;

public class LinkedHashCache<K, V> implements ICache<K, V> {
	
	private int capacity = 0;
	
	public IMap<K, DListNode<K,V>> map = new HashMap<K, DListNode<K,V>>();
	public DLinkedList<K,V> dLinkedList = new DLinkedList<K,V>();

	public LinkedHashCache(int capacity){
		this.capacity = capacity;
	}
	
	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		DListNode<K,V> dListNode = map.get(key);
		if(dListNode != null){
			dLinkedList.remove(dListNode);
		}
		if(size() == capacity){
			DListNode<K,V> firstNode = dLinkedList.head.next;
			dLinkedList.remove(firstNode);
			map.remove(firstNode.key);
		}
		dLinkedList.add(key,value);
		DListNode<K,V> newNode = dLinkedList.tail;
		map.put(key, newNode);
	}

	@Override
	public V get(K key) {
		DListNode<K,V> dListNode = map.get(key);
		if(dListNode != null){
			dLinkedList.remove(dListNode);
			dLinkedList.add(key,dListNode.data);
		}		
		return dListNode==null?null:dListNode.data;
	}

	@Override
	public int size() {
		return dLinkedList.size();
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public String display() {		
		return dLinkedList.display();
	}

}
