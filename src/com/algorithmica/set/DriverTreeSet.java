package com.algorithmica.set;

import java.util.Random;

import com.algorithmica.lists.IList;

public class DriverTreeSet {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ISortedSet<Integer> set = new TreeSet<Integer>();
		Random r = new Random();
		//set.add(100);
		int tmp = 0;
		int rint = 0;
		for(int i = 0; i < n; i++){
			rint = r.nextInt(100);
			if(i == 5){
				tmp = rint;
			}
			set.add(rint);
		}	

		set.display();
		System.out.println("size : "+set.size());
		//int ri = r.nextInt(set.size());
		//Integer select = set.select(ri);
		//System.out.println(ri+" : "+select);
		IList<Integer> findRange = set.findRange(10, 30);
		System.out.println("range : "+findRange.display());
//		set.remove(tmp);
//		set.display();
//		System.out.println("size : "+set.size());
		//boolean contains = set.contains(0);
		//System.out.println("contains 0 : "+contains);
		//System.out.println(set.size());
//		System.out.println(set.size());
//		set.remove(100);
//		System.out.println(set.display());
//		System.out.println(set.size());
	}
}
