package com.algorithmica.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<T> implements IQueue<T>{
	
	public LinkedList<T> list;

	@Override
	public void add(T e) {
		if(list==null)
			list = new LinkedList<T>();
			list.add(e);
	}

	@Override
	public T remove() {
		T e = null;
		if(list.size() > 0)e = list.remove(0);
		return e;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void display() {
		Iterator<T> iterator = list.iterator();
		for (T t : list) {
			System.out.print(t+" ");
		}
		System.out.println();
	}

}
