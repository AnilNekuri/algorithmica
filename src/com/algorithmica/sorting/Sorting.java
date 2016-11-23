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
	
	//inertion sort
	public static void insertionSort(int[] inArr){
		if(inArr.length > 1){
			for(int i = 1; i < inArr.length; i++){
				int current = inArr[i];
				int j = 0;
				for(j = i-1; j >= 0;j--){
					if(current < inArr[j]){
						inArr[j+1] = inArr[j] ;
					}else
						break;
				}
				inArr[j+1] = current;
			}
		}		
	}
	
	public static void mergeSort(int[] inArr){
		
	}
	
	//public static void auxMergeSort(int[] ){
		
	}
}
