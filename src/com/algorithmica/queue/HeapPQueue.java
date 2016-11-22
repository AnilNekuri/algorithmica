package com.algorithmica.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPQueue<T extends Comparable<T>> implements IPQueue<T>{

	public List<T> heap;
	
	public HeapPQueue() {
		heap = new ArrayList<T>();
	}
	
	@Override
	public void add(T e) {
		heap.add(e);
		int ci = heap.size()-1;
		int pi = 0;
		while(ci != 0){
			T current = heap.get(ci);
			pi = (ci-1)/2;
			T parent = heap.get(pi);
			if(current.compareTo(parent) > 0){
				swap(ci,pi);
				ci = pi;
			}else
				break;
		};
	}

	private void swap(int ci, int pi) {
		T tmp = heap.get(ci);
		heap.set(ci, heap.get(pi));
		heap.set(pi, tmp);
	}

	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		System.out.println(heap.toString());
	}

}
