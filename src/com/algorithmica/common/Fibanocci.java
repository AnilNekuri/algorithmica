package com.algorithmica.common;

public class Fibanocci {
	
	static int n = 0;
	
	public static void main(String[] args) {
		
	}

	public static long fib1(long prev1,long prev2,long sum){
		if(n == 1 || n == 2){
			++n;
			return 1;
		}
		//() return 1;
		
		return prev1+prev2;
	}
}
