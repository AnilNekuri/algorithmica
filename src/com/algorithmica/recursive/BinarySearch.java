package com.algorithmica.recursive;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
	static int[] arr = null;
	static int s = -1;
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		arr = new int[n];
		s = Integer.parseInt(args[1]);
		Random r = new Random();
		for(int i = 0 ; i < n; i++){
			arr[i] = r.nextInt(10);			
		}
		Arrays.sort(arr);
		for (int  v : arr) {
			System.out.print(v+" ");
		}
		System.out.println();
		int index = search(0, n-1);
		System.out.println(index);
		
	}
	
	public static int search(int l,int r){
		if(l >= r){
			if(arr[l] == s) return l;
			return -1;
		}
		int m = (l+r)/2;
		if(arr[m] == s){
			return m;
		}else if(arr[m] < s){
			l = m+1;
		}else if(arr[m] > s){
			r = m-1;
		}
		return search(l, r);
	}
}
