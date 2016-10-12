package com.algorithmica.lists;

public class ListNode<E>{
	E data;
	ListNode<E> next;
	@SuppressWarnings("unchecked")
	public ListNode() {
		data = (E)new Object();
		next = null;
	}		
}