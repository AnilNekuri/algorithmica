package com.algorithmica.set;

public class BSTNode<T> {
	
	public T data;
	public BSTNode<T> left;
	public BSTNode<T> right;
	public BSTNode<T> parent;
	public int lts = 0;

	public BSTNode(T data) {
		super();
		this.data = data;
		lts = 0;
	}

	public BSTNode() {
		super();
	}
	
	
}
