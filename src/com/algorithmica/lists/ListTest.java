package com.algorithmica.lists;

import java.util.Random;

public class ListTest {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Integer[] arr = new Integer[n];
		for(int i = 0; i<n; i++){
			Random r = new Random();
			int rInt = r.nextInt(100);
			arr[i] = rInt;
		}
		
		
		iList<Integer> list = new ArrayList<Integer>();		
		list.add(arr);
		list.display();
		list.reverse();
		list.display();
		System.out.println(list.size());
	}
	
}
