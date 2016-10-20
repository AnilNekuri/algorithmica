package com.algorithmica.recursive;

public class PowerComputation {

	public long power(long x,long n){
		if(n == 1){
			return x;
		}
		long tmp = power(x, n/2);
		if(n % 2 == 0){// % is very costly operation 
			return tmp*tmp;
		}else{
			return x*tmp*tmp;
		}
	}
	
	public static void main(String[] args) {
		PowerComputation pc = new PowerComputation();
		int x = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		long value = pc.power(x, n);
		System.out.println(x+" porer "+n+" : "+value);
	}
}
