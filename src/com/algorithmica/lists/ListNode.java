package com.algorithmica.lists;

public class ListNode<E>{
	public E data;
	public ListNode<E> next;
	@SuppressWarnings("unchecked")
	public ListNode() {
		data = (E)new Object();
		next = null;
	}		
}