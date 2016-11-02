package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeDepth {

	BinaryTree<Integer> bt = null;
	
	public static void main(String[] args) {
		TreeDepth ts = new TreeDepth();
		ts.generateTree(Integer.parseInt(args[0]));		
		int depthR = ts.depthR(ts.bt.root);
		System.out.println("depth : "+depthR);
		int depthQ = ts.depthQ();
		System.out.println("depth : "+depthQ);
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
	
	public int depthR(TreeNode<Integer> root){
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
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(bt.root);
		queue.add(null);
		depth++;
		
		while(!queue.isEmpty()){
			TreeNode<Integer> node = queue.remove();
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
}
