package com.algorithmica.lists;

public class ArrayList<E> extends AbstractList<E> implements iList<E> {

	private E[] array;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		array = (E[])new Object[10];
	}

	@Override
	public boolean add(E e) {
		if(array.length == size){
			@SuppressWarnings("unchecked")
			E[] newarray = (E[])new Object[array.length*2];		
			for(int i = 0; i < array.length;i++){
				newarray[i] = array[i];				
			}
			array = newarray;			
		}
		array[size] = e;	
		size++;
		return true;
	}

	@Override
	public boolean add(E[] array) {
		for (E e : array) {
			add(e);
		}
		return true;
	}

	@Override
	public E get(int index) {
		E e = null;
		if(index < size){
			e = array[index];
		}
		return e;
	}

	@Override
	public E remove(int index) {
		E e = null;
		if(index < size){
			int i = index;
			for(; i < size-1; i++){
				array[i] = array[i+1];
			}
			array[i] = null;
			--size;
		}
		return e;
	}

	@Override
	public boolean remove(E value) {
		if(value != null){
			for(int i = 0; i < size; i++){
				if(value.equals(array[i])){
					remove(i);
					return true;
				}
			}	
		}		
		return false;
	}

	@Override
	public String display() {
		String value = "";
		for(int i = 0; i < size; i++){
			//System.out.print(array[i]+" ");
			value += array[i]+" ";
		}
		value += "\n";
		System.out.print(value);
		return value;
	}

	@Override
	public boolean contains(E value) {
		if(size > 0 && value!=null){
			for(int i = 0; i < size; i++){
				if(value.equals(array[i])){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public iList<E> reverse() {
		int n = size/2;
		for(int i = 0; i < n;i++){
			E temp = array[i];
			array[i] = array[size-i-1];
			array[size-i-1] = temp;
		}
		return this;
	}

}
