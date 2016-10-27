package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeSize<T> {
	
	TreeNode<T> root = null;

	public static void main(String[] args) {
		TreeSize<Integer> ts = new TreeSize<Integer>();
		ts.generateTree(Integer.parseInt(args[0]));
		int sizeR = ts.sizeR(ts.root);
		ts.displayTree();
		System.out.println(sizeR);		
		int sizeQ = ts.sizeQ(ts.root);
		System.out.println(sizeQ);
		
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
	
	public void printNode(TreeNode<T> node,int level){
		
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
	
	public void printNull(int level){
		String whiteSpace = "";
		for(int i = 0;i<level;i++){
			whiteSpace += "   ";
		}
		System.out.println(whiteSpace+"|__null");
	}
	
}
