package com.algorithmica.tree;

public class BinaryTree<T> {

	TreeNode<T> root = null;
	
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
