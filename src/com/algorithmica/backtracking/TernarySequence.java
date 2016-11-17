package com.algorithmica.backtracking;

import java.util.Arrays;

public class TernarySequence {

	static int n = 0;
	
	public static void main(String[] args) {
		n = Integer.parseInt(args[0]);
		tseq(new int[n], n);
	}
	
	public static void tseq(int[] ter, int d) {
		if (d <= 0) {
			System.out.println(Arrays.toString(ter));
			return;
		}
		for (int i = 0; i <= 2; i++) {
			ter[n - d] = i;
			tseq(ter, d-1);
		}
	}
}
