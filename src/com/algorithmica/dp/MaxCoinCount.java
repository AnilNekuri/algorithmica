package com.algorithmica.dp;

import java.util.Random;

public class MaxCoinCount {

	int[][] grid;
	int nc = 0;
	int nr = 0;
	
	public static void main(String[] args) {
		
		MaxCoinCount mc = new MaxCoinCount();
		mc.nc = Integer.parseInt(args[0]);
		mc.grid = new int[mc.nc][mc.nc];
		mc.fillGrid();
		mc.displayGrid();				
		mc.maxRec(0, 0, 0);
	}
	
	public void fillGrid(){
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = getRandom();
			}
		}
	}
	
	public int getRandom(){
		int ran = 0;
		Random r = new Random();
		while(true){
			ran = r.nextInt(100);
			if(ran>=10) return ran;
		}		
	}
	
	public void displayGrid(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public int maxRec(int i,int j,int sum){		
		if(i >= nc || j >= nc) return 0;
		if(i == nc-1 && j == nc-1) {
			System.out.println(sum + grid[i][j]);
			return sum + grid[i][j];			
			}
		if(i < nc) sum += maxRec(i+1, j, sum);
		if(j < nc) sum += maxRec(i, j+1, sum);		
		return sum;
	}
	
}
