package com.algorithmica.lists;

public class DCircularLinkedList<K,E>{

	private int size;
	public DListNode<K,E> head;
	public DCircularLinkedList() {
		 head = new DListNode<K,E>(null,null);
		 head.prev = head;
		 head.next = head;
		 size = 0;
	}
	
	public boolean add(K k,E e) {
		DListNode<K,E> current = new DListNode<K,E>(k,e);
		head.prev.next = current;	
		current.prev = head.prev;
		current.next = head;
		head.prev = current;
		++size;
		return true;
	}
	
	public boolean remove(DListNode<K,E> node){
		if(node!=null && node!=head){
			DListNode<K,E> prev = node.prev;
			DListNode<K,E> next = node.next;
			prev.next = next;
			next.prev = prev;
			--size;
		}
		return true;
	}

	public String display() {
		String values = "";
		for(DListNode<K,E> node = head.next; node != head; node = node.next ){
			values += node.key+" : "+ node.data+" , ";
		}
		return values;
	}

	public int size() {
		return size;
	}

}
