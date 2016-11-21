package com.algorithmica.queue;

public interface IPQueue<T> {

	void add(T e)
	T findMax();
	T removeMax();
	int size();
	void display();
	
}
