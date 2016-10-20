package com.algorithmica.lists;

public class DListNode<E> {

	public E data;
	public DListNode<E> prev;
	public DListNode<E> next;
	@SuppressWarnings("unchecked")
	public DListNode() {
		data = (E)new Object();
		prev = null;
		next = null;
	}		

}
