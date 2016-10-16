package com.algorithmica.set;

public interface ISet<E> {

	boolean add(E e);
	boolean contains(E e);
	boolean remove(E e);
	int size();
	String display();	
}
