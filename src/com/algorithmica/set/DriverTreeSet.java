package com.algorithmica.set;

import java.util.Random;

public class DriverTreeSet {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ISet<Integer> set = new TreeSet<Integer>();
		Random r = new Random();
		//set.add(100);
		for(int i = 0; i < n; i++){
			set.add(r.nextInt(100));
		}	
		
		set.display();
		boolean contains = set.contains(0);
		System.out.println("contains 0 : "+contains);
		System.out.println(set.size());
//		System.out.println(set.size());
//		set.remove(100);
//		System.out.println(set.display());
//		System.out.println(set.size());
	}
}
