package com.algorithmica.compare;

public class CompareSortedArrays {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i = 0; i < n; i ++){
			a[i] = i;
			b[i] = i + (n-2);
		}
		long startTime = System.currentTimeMillis();
		String common = compareSortedArrays(a, b);
		long endTime = System.currentTimeMillis();
		System.out.println(common);
		System.out.println(((endTime - startTime)/1000.0));
	}
	
	public static String compareSortedArrays(int[] a,int[] b){
		String common = "";
		
		int aIndex = 0;
		int bIndex = 0;
		
		while(aIndex < a.length && bIndex < b.length){
			if(a[aIndex] == b[bIndex]){
				common += a[aIndex] + " ";
				aIndex++;
				bIndex++;
			}else if(a[aIndex] < b[bIndex]){
				aIndex++;
			}else{
				bIndex++;
			}	
		}
		
		return common;
	}
}
