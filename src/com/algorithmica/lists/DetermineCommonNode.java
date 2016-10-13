package com.algorithmica.lists;

import java.util.Random;

public class DetermineCommonNode {

	public LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
	
	public LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		DetermineCommonNode cn = new DetermineCommonNode();
		cn.loadLinkedListWithLoop(Integer.parseInt(args[0]), cn.linkedList1);
		cn.loadLinkedListWithLoop(Integer.parseInt(args[0]), cn.linkedList2);
		cn.linkLists(Integer.parseInt(args[1]));
		cn.linkedList1.display();
		cn.linkedList2.display();
		ListNode<Integer> commonNode = cn.commonNode1();
		System.out.println("first common node : "+commonNode.data);
	}	
	
	public void loadLinkedListWithLoop(int n,LinkedList<Integer> linkedList){			
		Integer[] arr = new Integer[n];
		for(int i = 0; i<n; i++){
			Random r = new Random();
			int rInt = r.nextInt(100);
			arr[i] = rInt;
		}
		linkedList.add(arr);
		//linkedList.display();
	}
	
	public void linkLists(int n){
		ListNode<Integer> node = linkedList1.head;
		for(int i = 0; i < n ;i++){
			node = node.next;
		}
		linkedList2.tail.next = node;
	}
	
	public ListNode<Integer> commonNode1(){
		ListNode<Integer> p1 = linkedList1.head;
		ListNode<Integer> p2 = linkedList2.head;
		while(p1 != p2){
			if((p1 = p1.next) == null){
				p1 = linkedList2.head;
			}
			if((p2 = p2.next) == null){
				p2 = linkedList1.head;
			}
		}
		return p2;
	}
}
