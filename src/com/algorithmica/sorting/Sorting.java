package com.algorithmica.sorting;

import java.util.Set;
import java.util.TreeSet;

public class Sorting {

	public static void treeSort(int[] arr){
		Set<Integer> ts = new TreeSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			ts.add(arr[i]);
		}
	}
	
	//heap sort
}
