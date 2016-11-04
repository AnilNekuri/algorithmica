package com.algorithmica.set;

import com.algorithmica.lists.IList;

@SuppressWarnings("rawtypes")
public class TreeSet<T extends Comparable> implements ISortedSet<T> {

	BSTNode<T> root = null;
	
	int size = 0;
	
	@Override
	public boolean add(T e) {
		if(e != null){
			BSTNode<T> current = new BSTNode<T>(e);
			if(add(root, current)){
				++size;
				return true;
			}
			 
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private boolean add(BSTNode<T> root,BSTNode<T> current){
		boolean status = false;
		if(root == null){
			this.root = current;
			return true;
		}else{
			int comp = current.data.compareTo(root.data);
			if(comp < 0){
				if(root.left != null){
					status = add(root.left,current);
				}else{
					root.left = current;
					return true;
				}				
			}else if(comp > 0){
				if(root.right != null){
					status = add(root.right,current);
				}else{
					root.right = current;
					return true;
				}
			}
		}
		return status;
	}
	
	@Override
	public boolean contains(T e) {
		return contains(root, e);
	}
	
	private boolean contains(BSTNode<T> root,T e){
		boolean contains = false;
		if(root == null) return false;
		if(root.data.equals(e))return true;
		@SuppressWarnings("unchecked")
		int comp = e.compareTo(root.data);
		if(comp < 0)contains = contains(root.left,e);
		else if(comp > 0)contains = contains(root.right, e);
		return contains;
	}

	@Override
	public boolean remove(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String display() {
		printInOrder(root);
		System.out.println();
		printNode(root,0);
		return null;
	}
	
	private void printInOrder(BSTNode<T> root){
		if(root == null) return;
		if(root.left != null) printInOrder(root.left);
		System.out.print(root.data+",");
		if(root.right != null) printInOrder(root.right);		
	}

	private void printNode(BSTNode<T> node,int level){
		
		if(node == null) return;
		String whiteSpace = "";
		for(int i = 0;i<level;i++){
												whiteSpace += "   ";
		}
		System.out.println(whiteSpace+"|__"+(node.data.toString().length() == 1 ? node.data.toString()+" " : node.data.toString()));
		//System.out.print(whiteSpace+(node.data.toString().length() == 1 ? node.data.toString()+" " : node.data.toString())+"-->");
		level = level+1;
		if(node.left != null || node.right != null){
			if(node.left != null)printNode(node.left,level);	
			else printNull(level);
			//System.out.println();
			if(node.right != null)printNode(node.right,level);	
			else printNull(level);
		}		
	}

	private void printNull(int level){
		String whiteSpace = "";
		for(int i = 0;i<level;i++){
			whiteSpace += "   ";
		}
		System.out.println(whiteSpace+"|__null");
	}
	
	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int select(int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IList<T> findRange(T s, T m) {
		// TODO Auto-generated method stub
		return null;
	}

}
