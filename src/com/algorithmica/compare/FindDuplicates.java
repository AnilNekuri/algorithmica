package com.algorithmica.compare;

public class FindDuplicates {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] a = new int[n];
		for(int i = 1; i < n; i++){
			a[i-1] = i;
		}
		a[n-1] = 15;
//		for (int i : a) {
//			System.out.print(i+" ");
//		}
		System.out.println();
		long st = System.currentTimeMillis();
		int duplicate = duplicatesByNegation(a);
		System.out.println(duplicate);
		long et = System.currentTimeMillis();
		System.out.println((et-st)/1000.0);
	}
	
	public static int duplicatesByNegation(int[] a){
		
		int np = 0;
		for(int i = 0; i < a.length; i++){			
			np = Math.abs(a[i]) - 1;
			if(a[np] < 0){
				return a[i];
			}else{
				a[np] *= -1;
			}			
		}		
		return -1;
	}
	
	public static int duplicatesWithArIndex(int[] a){
		boolean[] b = new boolean[a.length];
		int np = 0;
		for(int i = 0; i < a.length; i++){
			np = a[i] -1;
			if(b[np]){
				return a[i];
			}else{
				b[np] = true;	
			}
		}		
		return -1;
	}
}
