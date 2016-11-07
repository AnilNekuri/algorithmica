package com.algorithmica.dp;

public class Fibonacci {

	long[] mem;
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);		
		Fibonacci f = new Fibonacci();
		f.mem = new long[n+1];
		long fib_num = f.fibDPLoop(n);
		System.out.println(n+" th fib number : "+fib_num);
	}
	
	public long fibRec(long n){
		
		if(n == 1 || n ==2){
			return 1;
		}
		return fibRec(n-1)+fibRec(n-2);
	}
	
	public long fibDP(int n){		
		if(n == 1 || n == 2) return 1;
		if(mem[n] == 0) 
			mem[n] = fibDP(n-1) + fibDP(n-2);		
		return mem[n];
	}
	
	public long fibDPLoop(int n){
		if(n < 3) return 1;
		mem[0] = 0;
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; i++){
			mem[i] = mem[i-1]+mem[i-2];
		}
		return mem[n];
	}
	
}
