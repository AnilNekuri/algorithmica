package com.algorithmica.cache;

import com.algorithmica.lists.DLinkedList;
import com.algorithmica.map.HashMap;
import com.algorithmica.map.IMap;

public class LinkedHashCache<K, V> implements ICache<K, V> {
	
	private int size = 0;
	private int capacity = 0;
	
	public IMap<K, V> map = new HashMap<K, V>();
	public DLinkedList<V> dLinkedList = new DLinkedList<V>();

	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

}
