package com.algorithmica.tree;

import java.util.Random;

public class MaxPathSum {

	BinaryTree<Integer> bt = null;
	
	int maxPathSum = 0;
	
	public static void main(String[] args) {
		MaxPathSum ts = new MaxPathSum();
		ts.generateTree(Integer.parseInt(args[0]));		
		
		int maxPathSum = ts.findMaxPathSumUsingAuxilaryPath(ts.bt.root);
		System.out.println("max path sum using aux path : "+maxPathSum);
		maxPathSum = ts.findMaxPathSumDivAndCon(ts.bt.root);
		System.out.println("max path sum using div & con : "+maxPathSum);
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
	
	public int findMaxPathSumUsingAuxilaryPath(TreeNode<Integer> root){
		pathSum(root, 0);
		return maxPathSum;
	}
	
	private void pathSum(TreeNode<Integer> root,int sum){		
		if(root == null) return;
		sum = sum+(Integer)root.data;
		if(root.left == null && root.right == null) maxPathSum = (Integer) Math.max(sum, maxPathSum);		
		if(root.left != null) pathSum(root.left, sum);
		if(root.right != null) pathSum(root.right, sum);
	}
	
	public int findMaxPathSumDivAndCon(TreeNode<Integer> root){
		int leftPathSize = 0;
		int rightPathSize = 0;
		if(root == null) return 0;
		if(root.left == null && root.right == null) return (Integer)root.data;
		leftPathSize = rightPathSize = (Integer)root.data;
		if(root.left != null) leftPathSize += findMaxPathSumDivAndCon(root.left);
		if(root.right != null) rightPathSize += findMaxPathSumDivAndCon(root.right);
		return Math.max(leftPathSize, rightPathSize);
	}
}
