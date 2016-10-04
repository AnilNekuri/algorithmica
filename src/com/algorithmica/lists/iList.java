package com.algorithmica.lists;

public interface iList<E> {

	public boolean add(E e);
	
	public boolean add(E[] array);
	
	public E get(int index);
	
	public E remove(int index);
	
	public boolean remove(E value); 
	
	public String display();
	
	public boolean contains(E value);
	
}
