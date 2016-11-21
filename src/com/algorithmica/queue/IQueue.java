package com.algorithmica.queue;

public interface IQueue<T> {

	void add(T e);
	T remove();
	int size();
	void display();
}
