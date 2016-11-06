package com.algorithmica.set;

import com.algorithmica.lists.ArrayList;
import com.algorithmica.lists.IList;

@SuppressWarnings("rawtypes")
public class TreeSet<T extends Comparable> implements ISortedSet<T> {

	BSTNode<T> root = null;
	
	int size = 0;
	
	@Override
	public boolean add(T e) {
		if(e != null){
			if(contains(e)) return false;
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
					root.lts = root.lts+1;
					status = add(root.left,current);
				}else{
					root.lts = root.lts+1;
					root.left = current;
					current.parent = root;
					return true;
				}	
				
			}else if(comp > 0){
				if(root.right != null){
					status = add(root.right,current);
				}else{
					root.right = current;
					current.parent = root;
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
		BSTNode<T> rNode = identifyNode(root, e);
		if(rNode == null) return false;
		System.out.println("identifyNode : "+rNode.data);
		if(rNode.left == null && rNode.right == null){
			removeNode(rNode);			
		}else{
			BSTNode<T> tmp = null;
			if(rNode.left != null)
				tmp = maxNode(rNode.left);
			//System.out.println("max : "+tmp.data);
			if(rNode.right != null)
				tmp = minNode(rNode.right);
			//System.out.println("min : "+tmp.data);
			rNode.data = tmp.data;
			removeNode(tmp);
		}
		--size;
		return true;
	}

	private BSTNode<T> minNode(BSTNode<T> node){
		BSTNode<T> minNode = null;
		if(node.left != null) minNode = minNode(node.left);	
		else minNode = node;
		return minNode;
	}

	private BSTNode<T> maxNode(BSTNode<T> node){
		BSTNode<T> maxNode = null;
		if(node.right != null) maxNode = maxNode(node.right);	
		else maxNode = node;
		return maxNode;
	}

	
	private void removeNode(BSTNode<T> node){
		if(node.parent.left == node)
			node.parent.left = null;
		if(node.parent.right == node)
			node.parent.right = null;
		node = null;
	}	
	
	@SuppressWarnings("unchecked")
	private BSTNode<T> identifyNode(BSTNode<T> node,T e){
		BSTNode<T> rNode = null;
		if(node == null){
			return null;
		}
		if(node.data.equals(e)){
			rNode = node;
		}else if(e.compareTo(node.data) > 0){
			rNode = identifyNode(node.right, e);			
		}else{
			rNode = identifyNode(node.left, e);
		}		
		return rNode;
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
		System.out.print("["+root.lts+" - "+root.data+"],");
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
		return minNode(root).data;
	}

	@Override
	public T findMax() {
		return maxNode(root).data;
	}

	@Override
	public T select(int k) {		
		return select(root,k).data;
	}
	
	private BSTNode<T> select(BSTNode<T> node,int k){
		BSTNode<T> e = null;
		if(k == node.lts){
			e = node;
		}else if(k < node.lts){
			//System.out.println(k+" "+node.lts+" "+node.data);
			e =select(node.left,k);
		}else{
			e = select(node.right, k - 1 - node.lts);
		}
		return e;
	}

	@Override
	public IList<T> findRange(T s, T m) {		
		IList<T> range = new ArrayList<T>();
		range(root, s, m, range);
		return range;
	}
	
	@SuppressWarnings("unchecked")
	private void range(BSTNode<T> root, T s, T m, IList<T> range) {
		if (root == null)
			return;
		if (root.left != null)
			range(root.left, s, m, range);
		if (s.compareTo(root.data) <= 0 && m.compareTo(root.data) >= 0) {
			range.add(root.data);
		}
		if (root.right != null)
			range(root.right, s, m, range);

	}

}
