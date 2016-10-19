package com.algorithmica.lists;

public class LinkedList<E> extends AbstractList<E> implements IList<E> {
	
	public ListNode<E> head;
	public ListNode<E> tail;
	public LinkedList() {
		head = tail = null;
	}

	@Override
	public boolean add(E e) {
		ListNode<E> current = new ListNode<E>();
		current.data = e;
		if(head == null){
			head = current;			
		}else{
			tail.next = current;			
		}
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
		ListNode<E> node = head;
		
		if(index < size){
			for(int i = 0;i < index;i++){
				node = node.next;
			}	
		}		
		return node.data;
	}

	@Override
	public E remove(int index) {
		ListNode<E> node = head;
		ListNode<E> temp = null;
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

	@Override
	public String display() {
		String values = "";
		for(ListNode<E> node = head; node !=null; node = node.next ){
			values += node.data+" ";
		}
		System.out.println(values);
		return values;
	}

	@Override
	public boolean contains(E value) {
		for(ListNode<E> node = head; node !=null; node = node.next ){
			if(node.data.equals(value)){
				return true;
			}
		}
		return false;
	}

	@Override
	public IList<E> reverse() {
		
		ListNode<E> prev = null;
		ListNode<E> current = head; 
		tail = head;
		while(current != null){
			ListNode<E> temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		head = prev;		
		return this;
	}

}
