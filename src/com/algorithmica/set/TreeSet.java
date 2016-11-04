package com.algorithmica.set;

import com.algorithmica.lists.IList;

@SuppressWarnings("rawtypes")
public class TreeSet<T extends Comparable> implements ISortedSet<T> {

	BSTNode<T> root = null;
	
	int size = 0;
	
	boolean remove = false;
	
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
		
		if(root != null)remove(root, e);
		else System.out.println("Set is empty!");
		return false;
	}
	
	private boolean remove(BSTNode<T> root,T e){
		boolean status = false;
		boolean left = true;
		if(root == null) return false;
		if(root.data.equals(e))return true;
		
		@SuppressWarnings("unchecked")
		int comp = e.compareTo(root.data);
		BSTNode<T> child = null;
		if(comp < 0){
			child = root.left;
			left = true;			
		}else{
			child = root.right;
			left = false;
		}
		status = remove(child,e);
		if(status && !remove){
			removeNode(root,child,left);
			--size;
		}		
		return status;
	}
	
	private void removeNode(BSTNode<T> root,BSTNode<T> rNode,boolean left){	
		
		System.out.println(root.data+" - "+rNode.data+" - "+left);
		if(rNode.right == null && rNode.left == null){
			if(left){
				root.left = null;
			}else{
				root.right = null;
			}
		}
		if(rNode.right != null )
			rNode.data = leftMostNode(rNode.right, rNode,0);
		if(rNode.left != null )
			rNode.data = rightMostNode(rNode.left, rNode,0);
		remove = true;
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
	

	
	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private T leftMostNode(BSTNode<T> node,BSTNode<T> parent,int c){
		if(node.left != null) return leftMostNode(node.left,node,++c);
		else{
			if(node.right != null){
				parent.left = node.right;
			}else{
				if(c > 0)parent.left = null;
				else parent.right = null;
			}
			return node.data;
		} 
	}
	
	private T rightMostNode(BSTNode<T> node,BSTNode<T> parent,int c){
		if(node.right != null) return rightMostNode(node.right,node,++c);
		else{
			if(node.left != null){
				parent.right = node.left;
			}else{
				if(c > 0)parent.right = null;
				else parent.left = null;
			}
			return node.data;
		} 
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

}
