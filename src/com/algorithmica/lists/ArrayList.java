package com.algorithmica.lists;

public class ArrayList<E> implements iList<E> {
	
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		// TODO Auto-generated constructor stub
		array = (E[])new Object[10];  
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E[] array) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(E value) {
		// TODO Auto-generated method stub
		return false;
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

}
