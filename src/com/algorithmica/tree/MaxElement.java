package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

//This code have an issue.
public class MaxElement {

	BinaryTree<Integer> bt = null;
	
	TreeNode<Integer> maxNode = null;
	
	public static void main(String[] args) {
		MaxElement ts = new MaxElement();
		ts.generateTree(Integer.parseInt(args[0]));
		
		TreeNode<Integer> maxR = ts.maxR(ts.bt.root);
		System.out.println("maxR value : "+maxR.data);
		TreeNode<Integer> maxQ = ts.maxQ();
		System.out.println("maxQ value : "+maxQ.data);
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
	
	public TreeNode<Integer> maxR(TreeNode<Integer> root){
		TreeNode<Integer> leftMax = null;
		TreeNode<Integer> rightMax = null;
		if(root == null)
			return root;
		if(root.left == null && root.right == null) return root;
		if(root.left != null) leftMax = maxR(root.left);
		if(root.right != null) rightMax = maxR(root.right);
		TreeNode<Integer> max = findMax(root,leftMax, rightMax);
		return max;
	}
	
	public TreeNode<Integer> maxQ(){
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(bt.root);
		maxNode = bt.root;
		
		while(!queue.isEmpty()){
			TreeNode<Integer> tmp = queue.remove();
			maxNode = tmp.data.compareTo(maxNode.data) > 0 ? tmp : maxNode;
			if(tmp.left != null)queue.add(tmp.left);
			if(tmp.right != null)queue.add(tmp.right);
		}
		return maxNode;
	}
	
	private TreeNode<Integer> findMax(TreeNode<Integer> root,TreeNode<Integer> left,TreeNode<Integer> right){	
		TreeNode<Integer> max = null;
		if(left == null){
			max = (right.data).compareTo(root.data) > 0 ? right : root;
		}
		else if(right == null){
			max = (left.data).compareTo(root.data) > 0 ? left : root;
		}else{			
				if(right == null || (left.data).compareTo(right.data) > 0){
					max = (left.data).compareTo(root.data) > 0 ? left : root;
				}else{
					max = (right.data).compareTo(root.data) > 0 ? right : root;
				}
		}
		return max;
	}
	
}
