package com.algorithmica.backtracking;

import java.util.Arrays;

public class TernaryCharSequence {

	static int nc = 0;
	static int n  = 0;
	
	public static void main(String[] args) {
		nc = Integer.parseInt(args[0]);
		n  = Integer.parseInt(args[1]);
		terSeq(new char[n], n);
	}
	
	public static void terSeq(char[] arr,int d){
		if(d == 0){
			System.out.println(Arrays.toString(arr));
			return;
		}
		char c = 'A';
		for(int i = 0; i < nc;i++,c++){
			arr[n-d] = c;
			terSeq(arr, d-1);
		}
	}
}
