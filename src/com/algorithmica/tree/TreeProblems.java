package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import sun.reflect.generics.tree.Tree;

public class TreeProblems<T> {
	
	TreeNode<T> root = null;
	
	TreeNode<T> maxNode = null;
	
	public static void main(String[] args) {
		TreeProblems<Integer> ts = new TreeProblems<Integer>();
		ts.generateTree(Integer.parseInt(args[0]));
		ts.displayTree();
		
		//size
//		int sizeR = ts.sizeR(ts.root);		
//		System.out.println(sizeR);		
//		int sizeQ = ts.sizeQ(ts.root);
//		System.out.println(sizeQ);
		
		//depth
//		int depthR = ts.depthR(ts.root);
//		System.out.println("depth : "+depthR);
//		int depthQ = ts.depthQ();
//		System.out.println("depth : "+depthQ);
		
		TreeNode<Integer> maxR = ts.maxR(ts.root);
		System.out.println("max value : "+maxR.data);
	}
	
	public  int sizeR(TreeNode<T> root){
		if(root == null) return 0;	
		//if(root.left == null && root.right == null) return 1;
		int ls = sizeR(root.left);
		int rs = sizeR(root.right);
		return 1+ls+rs;		
	}
	
	public  int sizeQ(TreeNode<T> root){
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(root);
		int size = 0;
		
		while(!queue.isEmpty()){
			TreeNode<T> tmp = queue.remove();
			++size;
			if(tmp.left != null)queue.add(tmp.left);
			if(tmp.right != null)queue.add(tmp.right);
		}
		return size;
	}
	
	public int depthR(TreeNode<T> root){
		if(root == null) return 0;
		if(root.left == null && root.right == null){
			return 1;
		}
		int ld = 0;
		int rd = 0;
		if(root.left != null) 
			ld = depthR(root.left) + 1;
		if(root.right != null) 
			rd = depthR(root.right) + 1;
		return Math.max(ld, rd);
	}
	
	public int depthQ(){
		int depth = 0;
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(root);
		queue.add(null);
		depth++;
		
		while(!queue.isEmpty()){
			TreeNode<T> node = queue.remove();
			if(node == null && !queue.isEmpty()){
				queue.add(null);
				depth++;
				continue;
			}
			if(queue.isEmpty())break;
			if(node.left != null)queue.add(node.left);
			if(node.right != null)queue.add(node.right);
		}
		
		return depth;
		
	}
	
	public TreeNode<T> maxR(TreeNode<T> root){
		TreeNode<T> leftMax = null;
		TreeNode<T> rightMax = null;
		if(root == null)
			return root;
		if(root.left == null && root.right == null) return root;
		if(root.left != null) leftMax = maxR(root.left);
		if(root.right != null) rightMax = maxR(root.right);
		TreeNode<T> max = findMax(root,leftMax, rightMax);
		return max;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private TreeNode<T> findMax(TreeNode<T> root,TreeNode<T> left,TreeNode<T> right){	
		TreeNode<T> max = null;
		if(left == null){
			max = right;
		}
		else if(right == null){
			max = left;
		}else{
			if(left.data instanceof Comparable) {
				if(((Comparable)left.data).compareTo((Comparable)right.data) > 0){
					max = ((Comparable)left.data).compareTo((Comparable)root.data) > 0 ? left : root;
				}else{
					max = ((Comparable)right.data).compareTo((Comparable)root.data) > 0 ? right : root;
				}
			}
		}
		return max;
	}
	
	@SuppressWarnings("unchecked")
	public void generateTree(int size){
		Random r = new Random();
		for(int i = 0; i < size; i++){
			TreeNode<Integer> node = new TreeNode<Integer>();
			node.data = r.nextInt(100);
			addNode((TreeNode<T>)node);
		}
	}
	
	public void addNode(TreeNode<T> node){
		if(root == null){
			root = node;
		}else{	
			TreeNode<T> tmp = root;
			while(true){
				if(Math.random() > .5){
					if(tmp.left == null){
						tmp.left = node;
						break;
					}
					tmp = tmp.left;
				}else{
					if(tmp.right == null){
						tmp.right = node;
						break;
					}
					tmp = tmp.right;
				}	
			}
			
		}
	}
	
	public void displayTree(){
		printNode(root,0);
	}
	
	private void printNode(TreeNode<T> node,int level){
		
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
