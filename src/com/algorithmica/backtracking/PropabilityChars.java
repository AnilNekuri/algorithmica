package com.algorithmica.backtracking;

import java.util.Arrays;

public class PropabilityChars {

	static int n = 0;
	
	public static void main(String[] args) {
		n = Integer.parseInt(args[0]);
		prop(0, new char[n]);
	}
	
	public static boolean isValid(char[] cArr,char c,int d){
		boolean isValid = true;
		for(int i = 0; i < d;i++){
			if(cArr[i] == c){
				isValid = false;
				break;
			}
		}
		return isValid;
	}
	
	public static void prop(int d,char[] cArr){
		if(d == n){
			System.out.println(Arrays.toString(cArr));
			return;
		}
		int i = 0;
		for(char c = 'A';  i < n; i++,c++){
			if(isValid(cArr, c, d)){
				cArr[d] = c;
				prop(d+1, cArr);	
			}
			
		}
	}
	
}
