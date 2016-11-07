package com.algorithmica.dp;

public class OptmProblem {

	long mem[];
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		OptmProblem op = new OptmProblem();
		op.mem = new long[n+1];
		long opVal = op.optDpFor(n);
		System.out.println(opVal);
	}
	
	public long optRec(int n){
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		return optRec(n-1)+optRec(n-2)+optRec(n-3);
	}
	
	public long optDp(int n){
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		if(mem[n] == 0)
			mem[n] = optDp(n-1)+optDp(n-2)+optDp(n-3);
		return mem[n];
	}
	
	public long optDpFor(int n){
		mem[2] = mem[1] = 1;
		for(int i = 3; i <= n; i++){
			mem[i] = mem[i-1]+mem[i-2]+mem[i-3];
		}		
		return mem[n];
	}		
}
