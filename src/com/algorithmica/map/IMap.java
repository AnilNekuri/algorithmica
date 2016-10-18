package com.algorithmica.map;

public interface IMap<K,V> {

	void put(K key,V value);
	
	V get(K key);
	
	boolean containsKey(K key);
	
	boolean containsValue(V value);
	
	boolean remove(K key);
	
	int size();
	
	String display();
}
