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
		System.out.println(count);
	}

	public static void placeQns(int[] qs, int r) {
		if (r == n) {
			System.out.println(Arrays.toString(qs));
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
}
