package com.algorithmica.lists;

public class DLinkedList<E> extends AbstractList<E> implements IList<E> {

	public DListNode<E> head;
	public DListNode<E> tail;
	public DLinkedList() {
		 tail = head;
		 head.prev = head;
		 head.next = head;
	}
	
	@Override
	public boolean add(E e) {
		DListNode<E> current = new DListNode<E>();
		current.data = e;
		tail.next = current;	
		current.prev = tail;
		tail = current;
		++size;
		return true;
	}

	@Override
	public boolean add(E[] array) {
		for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
		return true;
	}

	@Override
	public E get(int index) {
		DListNode<E> node = head.next;
		
		if(index < size){
			for(int i = 0;i < index;i++){
				node = node.next;
			}	
		}		
		return node.data;
	}

	@Override
	public E remove(int index) {
		DListNode<E> node = head;
		DListNode<E> temp = null;
		if(index < size){
			for(int i = 0;i < index-1;i++){
				node = node.next;
			}
			temp = node.next;
			node.next = node.next.next;
			--size;
		}
		return temp.data;
	}

	@Override
	public boolean remove(E value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean remove(DListNode<E> node){
		if(node!=null && node!=head){
			DListNode<E> prev = node.prev;
			DListNode<E> next = node.next;
			prev.next = next;
			next.prev = prev;
			--size;
		}
		return true;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public IList<E> reverse() {
		// TODO Auto-generated method stub
		return null;
	}

}
