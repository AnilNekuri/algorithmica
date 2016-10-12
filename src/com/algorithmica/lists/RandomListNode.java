package com.algorithmica.lists;

import java.util.Random;

public class RandomListNode<E> {

	LinkedList<Integer> linkedList;
	
	public static void main(String[] args) {
		RandomListNode<Integer> randomList = new RandomListNode<Integer>();
		randomList.loadLinkedListWithLoop(Integer.parseInt(args[0]));
		ListNode<Integer> randomNode = randomList.randomNode(randomList.linkedList.head);
		System.out.println(randomNode.data);
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
	}
	
	public ListNode<E> randomNode(ListNode<E> head){
		Random r = new Random();
		ListNode<E> current = head;
		ListNode<E> random = null;
		int n = 1;
		
		while(current != null){
			int nextInt = r.nextInt(n);
			if(nextInt == (n-1))
				random = current;
			current = current.next;
			++n;
		}
		return random;
	}
}
