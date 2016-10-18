package com.algorithmica.set;

import com.algorithmica.lists.ListNode;

public class HashSet<E> implements ISet<E>{
	
	private ListNode<E>[] hstb;
	
	private int size = 0;
	
	private int llmSize = 20;
	
	@SuppressWarnings("unchecked")
	public HashSet(){
		hstb = (ListNode<E>[])new ListNode[11];
		size = 0;
		for(int i = 0; i < hstb.length; i++){
			hstb[i] = new ListNode<E>();
		}
	}
	
	private void rehash(){
		ListNode<E>[] tmp = hstb;
		@SuppressWarnings("unchecked")
		ListNode<E>[] newhstb = (ListNode<E>[])new ListNode[tmp.length*2];
		size = 0;
		for(int i = 0; i < newhstb.length; i++){
			newhstb[i] = new ListNode<E>();
		}
		hstb = newhstb;
		for(int i = 0; i < tmp.length; i++){			
			ListNode<E> currentNode = tmp[i].next;
			while(currentNode !=null){
				add(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}

	@Override
	public boolean add(E e) {	
		if(size / hstb.length > 20){
			rehash();
		}
		int bucket = e.hashCode() % hstb.length;
		ListNode<E> head = hstb[bucket];
		ListNode<E> currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.data.equals(e))
				return false;
			currentNode= currentNode.next;
		}
		ListNode<E> tmp = head.next;
		ListNode<E> node = new ListNode<E>();
		node.data = e;
		node.next = tmp;
		head.next = node;	
		++size;
		return true;
	}

	@Override
	public boolean contains(E e) {
		int bucket = e.hashCode() % hstb.length;
		ListNode<E> head = hstb[bucket];
		ListNode<E> currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.data.equals(e))
				return true;
			currentNode = currentNode.next;
		}
		return false;
	}

	@Override
	public boolean remove(E e) {
		int bucket = e.hashCode() % hstb.length;
		ListNode<E> head = hstb[bucket];
		ListNode<E> currentNode = head.next;
		ListNode<E> tmp = head;
		while (currentNode != null) {
			if (currentNode.data.equals(e)){
				tmp.next = currentNode.next;
				--size;
				return true;
			}				
			tmp = currentNode;
			currentNode = currentNode.next;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String display() {
		StringBuffer strBuff = new StringBuffer();
		for(int i = 0; i < hstb.length; i++){
			strBuff.append("bucket ["+i+"] : ");
			ListNode<E> currentNode = hstb[i].next;
			while(currentNode !=null){
				strBuff.append(currentNode.data+" ");
				currentNode = currentNode.next;
			}
			strBuff.append("\n");
		}
		return strBuff.toString();
	}

}
