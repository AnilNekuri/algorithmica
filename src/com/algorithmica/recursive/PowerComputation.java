package com.algorithmica.recursive;

import java.math.BigInteger;

public class PowerComputation {

	public BigInteger power(BigInteger x,BigInteger n){
		if(n.toString().equals("1")){
			return x;
		}
		BigInteger tmp = power(x, n.divide(new BigInteger("2")));
		
		if(n.mod(new BigInteger("2")).toString().equals("0")){// % is very costly operation 
			return tmp.multiply(tmp);
		}else{
			return x.multiply(tmp).multiply(tmp);
		}
	}
	
	public static void main(String[] args) {
		PowerComputation pc = new PowerComputation();
		BigInteger x = new BigInteger(args[0]);
		BigInteger n = new BigInteger(args[1]);
		BigInteger value = pc.power(x, n);
		System.out.println(x.toString()+" power "+n.toString()+" : "+value.toString());
	}

}
