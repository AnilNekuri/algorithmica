package com.algorithmica.lists;

import java.util.Random;

public class RemoveLoop {

	LinkedList<Integer> linkedList;
	
	public static void main(String[] args) {
		RemoveLoop removeLoop = new RemoveLoop();
		removeLoop.loadLinkedListWithLoop(Integer.parseInt(args[0]));
		removeLoop.removeLoop();
		System.out.println("size : "+removeLoop.linkedList.size());
	}
	
	private void removeLoop() {
		
		boolean containsLoop = true;
		if(linkedList.size > 0){
			ListNode<Integer> pointer1 = linkedList.head;
			ListNode<Integer> pointer2 = linkedList.head;
			ListNode<Integer> prevNode = null;
			do{
				prevNode = pointer1;
				if(pointer2.next == null || (pointer2 = pointer2.next.next) == null
						|| (pointer1 = pointer1.next) == null){
					containsLoop = false;
					break;
				}
		
			}while(pointer1!=pointer2);
			if(containsLoop){
				
				pointer2 = linkedList.head; 
				while(pointer2!=pointer1){
					prevNode = pointer1;
					pointer1 = pointer1.next;
					pointer2 = pointer2.next;
				}
				System.out.println(pointer1.data);
				prevNode.next = null;
			}
		}	
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
		linkedList.display();
		linkedList.tail.next = linkedList.head.next;
	}
	


}
