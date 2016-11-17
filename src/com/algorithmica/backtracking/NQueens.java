package com.algorithmica.backtracking;

import java.util.Arrays;

public class NQueens {

	static int n = 0;
	
	static int count = 0;

	public static void main(String[] args) {
		n = Integer.parseInt(args[0]);
		int[] qs = new int[n];
		Arrays.fill(qs, -1);
		placeQns(qs, 0);
		System.out.println();
		System.out.println("No of Comb: "+count);
	}

	public static void placeQns(int[] qs, int r) {
		if (r == n) {
			//System.out.println(Arrays.toString(qs));
			display(qs);
			System.out.println();
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(qs, i, r)) {
				qs[r] = i;
				placeQns(qs, r + 1);
			}
		}
	}

	public static boolean isValid(int[] qs, int c, int r) {
		boolean isValid = true;
		for (int i = 0; i < r && isValid; i++) {
			if (qs[i] == c || (i - qs[i]) == (r - c) || ((i + qs[i]) == (r + c)))
				isValid = false;
		}
		return isValid;
	}
	
	public static void display(int[] qs){
		for(int i = 0; i < qs.length; i++){			
			for(int j = 0; j < qs.length; j++){
				if(j == qs[i]){
					System.out.print(" Q");
				}else{
					System.out.print(" "+j);
				}
			}
			System.out.println();
		}
	}
}
