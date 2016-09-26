package com.algorithmica.compare;

import java.util.Arrays;

public class CompareBySortOneArr {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] a = new int[n];
		int[] b = new int[n];
 		for(int i = 0; i < n; i++){
			a[i] = i;
			b[i] = i+n-2;
		}
 		
 		String common = compare(a, b);
 		System.out.println(common);
	}
	
	public static String compare(int[] a,int[] b){
		
		Arrays.sort(b);
		
		String common = "";
		
		for (int i = 0; i < a.length; i++) {
			int index = Arrays.binarySearch(b, a[i]);
			if(index >= 0){
				common += b[index]+" ";
			}
		}
		
		return common;
	}

}
