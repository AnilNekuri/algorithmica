package com.algorithmica.sorting;

import java.util.Arrays;
import java.util.Random;

public class Driver {

	static Random r = new Random();
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] inArr = new int[n];
		for(int i = 0; i < n; i++){
			inArr[i] = getRandom(0, 100);
		}
		System.out.println(Arrays.toString(inArr));
		Sorting.mergeSort(inArr);
		System.out.println(Arrays.toString(inArr));
	}
	
	public static int getRandom(int min,int max){
		int ran = 0;		
		while(true){
			ran = r.nextInt(max);
			if(ran>=min) return ran;
		}		
	}
}
