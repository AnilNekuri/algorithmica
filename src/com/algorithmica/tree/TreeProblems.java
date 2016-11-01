package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class TreeProblems<T extends Comparable> {
	
	TreeNode<T> root = null;
	
	TreeNode<T> maxNode = null;
	
	int maxPathSum = 0;
	
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
		
		//max element
//		TreeNode<Integer> maxR = ts.maxR(ts.root);
//		System.out.println("maxR value : "+maxR.data);
//		TreeNode<Integer> maxQ = ts.maxQ();
//		System.out.println("maxQ value : "+maxQ.data);
		
		//max path sum
		int maxPathSum = ts.findMaxPathSumUsingAuxilaryPath(ts.root);
		System.out.println("max path sum using aux path : "+maxPathSum);
		maxPathSum = ts.findMaxPathSumDivAndCon(ts.root);
		System.out.println("max path sum using div & con : "+maxPathSum);
		
		
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
	
	@SuppressWarnings("unchecked")
	public TreeNode<T> maxQ(){
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(root);
		maxNode = root;
		
		while(!queue.isEmpty()){
			TreeNode<T> tmp = queue.remove();
			maxNode = tmp.data.compareTo(maxNode.data) > 0 ? tmp : maxNode;
			if(tmp.left != null)queue.add(tmp.left);
			if(tmp.right != null)queue.add(tmp.right);
		}
		return maxNode;
	}
	
	@SuppressWarnings({ "unchecked" })
	private TreeNode<T> findMax(TreeNode<T> root,TreeNode<T> left,TreeNode<T> right){	
		TreeNode<T> max = null;
		if(left == null){
			max = right;
		}
		else if(right == null){
			max = left;
		}else{
			//if(left.data instanceof Comparable) {
				if(((Comparable)left.data).compareTo((Comparable)right.data) > 0){
					max = ((Comparable)left.data).compareTo((Comparable)root.data) > 0 ? left : root;
				}else{
					max = ((Comparable)right.data).compareTo((Comparable)root.data) > 0 ? right : root;
				}
			//}
		}
		return max;
	}
	
	public int findMaxPathSumUsingAuxilaryPath(TreeNode<T> root){
		pathSum(root, 0);
		return maxPathSum;
	}
	
	private void pathSum(TreeNode<T> root,int sum){		
		if(root == null) return;
		sum = sum+(Integer)root.data;
		if(root.left == null && root.right == null) maxPathSum = (Integer) Math.max(sum, maxPathSum);		
		if(root.left != null) pathSum(root.left, sum);
		if(root.right != null) pathSum(root.right, sum);
	}
	
	public int findMaxPathSumDivAndCon(TreeNode<T> root){
		int leftPathSize = 0;
		int rightPathSize = 0;
		if(root == null) return 0;
		if(root.left == null && root.right == null) return (Integer)root.data;
		leftPathSize = rightPathSize = (Integer)root.data;
		if(root.left != null) leftPathSize += findMaxPathSumDivAndCon(root.left);
		if(root.right != null) rightPathSize += findMaxPathSumDivAndCon(root.right);
		return Math.max(leftPathSize, rightPathSize);
	}
	
	@SuppressWarnings("unchecked")
	public void generateTree(int size){
		Random r = new Random();
		for(int i = 0; i < size; i++){
			TreeNode<Integer> node = new TreeNode<Integer>();
			node.data = r.nextInt(10);
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
