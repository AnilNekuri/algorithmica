package com.algorithmica.greedy;

import java.util.Arrays;

public class NQueens {

	static int n = 0; 
	
	public static void main(String[] args) {
		
	}
	
	public static void placeQns(int[] qs,int d){
		if(d == n){
			System.out.println(Arrays.toString(qs));
			return;
		}
		for(int i = 0; i < n; i++){

		}
	}
	
	public static boolean isValid(int[] qs,int c){
		boolean isValid = true;
		for(int i = 0; i < n && qs[i] != -1 && isValid; i++){
			if(qs[i] == c) isValid = false;
			//if()
		}
		return false;
	}
}
