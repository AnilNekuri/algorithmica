package com.algorithmica.set;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ISet<Integer> set = new HashSet<>();
		Random r = new Random();
		set.add(100);
		for(int i = 0; i < n; i++){
			set.add(r.nextInt(1000));
		}	
		
		System.out.println(set.display());
		System.out.println(set.size());
		set.remove(100);
		System.out.println(set.display());
		System.out.println(set.size());
	}
}
