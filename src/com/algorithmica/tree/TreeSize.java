package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeSize {

	BinaryTree<Integer> bt = null;
	public static void main(String[] args) {
		TreeSize ts = new TreeSize();
		ts.generateTree(Integer.parseInt(args[0]));
		int sizeR = ts.sizeR(ts.bt.root);
		System.out.println("Size r : "+sizeR);		
		int sizeQ = ts.sizeQ(ts.bt.root);
		System.out.println("Size q: "+sizeQ);
		ts.bt.displayTree();
	}
	
	public void generateTree(int size){
		Random r = new Random();
		bt = new BinaryTree<Integer>();
		for(int i = 0; i < size; i++){
			TreeNode<Integer> node = new TreeNode<Integer>();
			node.data = r.nextInt(100);
			bt.addNode((TreeNode<Integer>)node);
		}
	}
	
	public  int sizeR(TreeNode<Integer> root){
		if(root == null) return 0;	
		//if(root.left == null && root.right == null) return 1;
		int ls = sizeR(root.left);
		int rs = sizeR(root.right);
		return 1+ls+rs;		
	}
	
	public  int sizeQ(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(root);
		int size = 0;
		
		while(!queue.isEmpty()){
			TreeNode<Integer> tmp = queue.remove();
			++size;
			if(tmp.left != null)queue.add(tmp.left);
			if(tmp.right != null)queue.add(tmp.right);
		}
		return size;
	}
}
