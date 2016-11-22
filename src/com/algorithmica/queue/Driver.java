package com.algorithmica.queue;

import java.util.Random;

public class Driver {

	static Random r = new Random();
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		IPQueue<Integer> pQueue = new HeapPQueue<Integer>();
		for(int i = 0; i < n; i++){
			int r = getRandom(10, 100);
			pQueue.add(r);
		}
		pQueue.display();
		Integer max = pQueue.removeMax();
		System.out.println(max);
		pQueue.display();
		max = pQueue.removeMax();
		System.out.println(max);
		pQueue.display();
	}
	
	public static int getRandom(int min,int max){
		int ran = 0;		
		while(true){
			ran = r.nextInt(max);
			if(ran>=min) return ran;
		}		
	}
}
