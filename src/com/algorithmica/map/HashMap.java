package com.algorithmica.map;

import com.algorithmica.map.ListNode;

public class HashMap<K, V> implements IMap<K, V> {

	private ListNode<K,V>[] hstb;
	
	private int size;
	
	private int llmSize = 20;
	
	@SuppressWarnings("unchecked")
	public HashMap(){
		hstb = (ListNode<K,V>[])new ListNode[11];
		size = 0;
		for(int i = 0; i < hstb.length; i++){
			hstb[i] = new ListNode<K,V>();
		}
	}
	
	private int getHashCode(K key){
		return Math.abs(key.hashCode());
	}
	
	private void rehash(){
		ListNode<K,V>[] tmp = hstb;
		@SuppressWarnings("unchecked")
		ListNode<K,V>[] newhstb = (ListNode<K,V>[])new ListNode[tmp.length*2];
		size = 0;
		for(int i = 0; i < newhstb.length; i++){
			newhstb[i] = new ListNode<K,V>();
		}
		hstb = newhstb;
		for(int i = 0; i < tmp.length; i++){			
			ListNode<K,V> currentNode = tmp[i].next;
			while(currentNode !=null){
				put(currentNode.key,currentNode.value);
				currentNode = currentNode.next;
			}
		}
	}
	
	@Override
	public void put(K key, V value) {
		if(size / hstb.length > 20){
			rehash();
		}
		int bucket = getHashCode(key) % hstb.length;
		ListNode<K,V> head = hstb[bucket];
		ListNode<K,V> currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.key.equals(key)){
				currentNode.value = value;
				return;
			}
			currentNode= currentNode.next;
		}
		ListNode<K,V> tmp = head.next;
		ListNode<K,V> node = new ListNode<K,V>(key,value);
		node.next = tmp;
		head.next = node;	
		++size;
	}

	@Override
	public V get(K key) {
		int bucket = getHashCode(key) % hstb.length;
		ListNode<K,V> head = hstb[bucket];
		ListNode<K,V> currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.key.equals(key))
				return currentNode.value;
			currentNode = currentNode.next;
		}	
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		int bucket = getHashCode(key) % hstb.length;
		ListNode<K,V> head = hstb[bucket];
		ListNode<K,V> currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.key.equals(key))
				return true;
			currentNode = currentNode.next;
		}	
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		for(int i = 0; i < hstb.length; i++){
			hstb[i] = new ListNode<K,V>();
			ListNode<K,V> head = hstb[i];
			ListNode<K,V> currentNode = head.next;
			while (currentNode != null) {
				if (currentNode.value.equals(value))
					return true;
				currentNode = currentNode.next;
			}
		}
		return false;
	}

	@Override
	public boolean remove(K key) {
		int bucket = getHashCode(key) % hstb.length;
		ListNode<K,V> head = hstb[bucket];
		ListNode<K,V> currentNode = head.next;
		ListNode<K,V> tmp = head;
		while (currentNode != null) {
			if (currentNode.key.equals(key)){
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
			strBuff.append("bucket ["+i+"] --> ");
			ListNode<K,V> currentNode = hstb[i].next;
			StringBuffer mapV = new StringBuffer();
			int count = 0;
			while(currentNode !=null){
				++count;
				mapV.append(currentNode.key+" : "+currentNode.value+" , ");
				currentNode = currentNode.next;
			}
			strBuff.append(count+" ");
			strBuff.append(mapV);
			strBuff.append("\n");
		}
		return strBuff.toString();
	}

}
