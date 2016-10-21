package com.algorithmica.lists;

public class DLinkedList<K,E>{

	private int size;
	public DListNode<K,E> head;
	public DListNode<K,E> tail;
	public DLinkedList() {
		 head = new DListNode<K,E>(null,null);
		 tail = head;
		 head.prev = head;
		 head.next = head;
		 size = 0;
	}
	
	public boolean add(K k,E e) {
		DListNode<K,E> current = new DListNode<K,E>(k,e);
		current.data = e;
		tail.next = current;	
		current.prev = tail;
		tail = current;
		++size;
		return true;
	}
	
	public boolean remove(DListNode<K,E> node){
		if(node!=null && node!=head){
			DListNode<K,E> prev = node.prev;
			DListNode<K,E> next = node.next;
			prev.next = next;
			if(next!=null)next.prev = prev;
			--size;
		}
		return true;
	}

	public String display() {
		String values = "";
		for(DListNode<K,E> node = head.next; node !=null; node = node.next ){
			values += node.key+" : "+ node.data+" , ";
		}
		return values;
	}

	public int size() {
		return size;
	}

}
