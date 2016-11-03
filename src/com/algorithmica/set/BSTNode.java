package com.algorithmica.set;

public class BSTNode<T> {
	
	public T data;
	public BSTNode<T> left;
	public BSTNode<T> right;
	int lst_size = 0;

	public BSTNode(T data) {
		super();
		this.data = data;
	}

	public BSTNode() {
		super();
	}
	
	
}
