package com.algorithmica.lists;

import java.util.Random;

public class LinkedListLoopDetect {

	LinkedList<Integer> linkedList;
	
	public static void main(String[] args) {
		LinkedListLoopDetect loopDetect = new LinkedListLoopDetect();
		loopDetect.loadLinkedListWithLoop(Integer.parseInt(args[0]));
		boolean containsLoop = loopDetect.containsLoop();
		System.out.println("containsLoop : "+containsLoop);
	}
	
	public void loadLinkedListWithLoop(int n){			
		Integer[] arr = new Integer[n];
		for(int i = 0; i<n; i++){
			Random r = new Random();
			int rInt = r.nextInt(100);
			arr[i] = rInt;
		}
		
		linkedList = new LinkedList<Integer>();
		linkedList.add(arr);
		linkedList.tail.next = linkedList.head;
	}
	
	public boolean containsLoop(){	
		boolean containsLoop = true;
		if(linkedList.size > 0){
			ListNode<Integer> pointer1 = linkedList.head;
			ListNode<Integer> pointer2 = linkedList.head;
			do{
				if(pointer2.next == null || (pointer2 = pointer2.next.next) == null
						|| (pointer1 = pointer1.next) == null){
					containsLoop = false;
					break;
				}
		
			}while(pointer1!=pointer2);
		}		
		return containsLoop;
	}
}
