package com.algorithmica.cache;

public interface ICache<K,V> {

	void put(K key,V value);
	V get(K key);
	int size();
	int capacity();
	String display();
}
