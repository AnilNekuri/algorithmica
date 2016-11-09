package com.algorithmica.dp;

import java.util.Random;
import java.util.Stack;

import com.algorithmica.lists.LinkedList;

public class MaxCoinCount {

	int[][] grid;
	int[][] gridMaxSum;
	int nc = 0;
	int nr = 0;
	int maxCoins = 0;
	
	public static void main(String[] args) {
		
		MaxCoinCount mc = new MaxCoinCount();
		mc.nc = Integer.parseInt(args[0]);
		mc.grid = new int[mc.nc][mc.nc];
		mc.fillGrid();
		//mc.displayGrid();		
		int maxCoins = mc.maxLoopDP();
		System.out.println("Max coins using loop and DP: "+maxCoins);
		mc.displayMaxCoinsPath();
//		maxCoins = mc.maxRec();
//		System.out.println("Max coins using recursive: "+maxCoins);
//		maxCoins = mc.maxDivAndConq();
//		System.out.println("Max coins using divide and conquer: "+maxCoins);
//		maxCoins = mc.maxDivAndConqDP();
//		System.out.println("Max coins using divide and conquer and DP: "+maxCoins);

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
	

	public int maxRec(){
		auxMaxRec(0, 0, 0);
		return maxCoins;
	}
	
	private void auxMaxRec(int i, int j, int sum) {
		if(i >= nc || j >= nc) return;
		sum += grid[i][j];
		if (i == nc - 1 && j == nc - 1) {
			maxCoins = Math.max(sum, maxCoins);
			return;
		}		
		if(i < nc-1) auxMaxRec(i+1, j, sum);
		if(j < nc-1) auxMaxRec(i, j+1, sum);
	}
	
	public int maxDivAndConq(){
		maxCoins = auxMaxDivAndConq(nc-1, nc-1);
		return maxCoins;
	}

	private int auxMaxDivAndConq(int i, int j) {
		if(i < 0 || j < 0) return 0;
		if(i == 0 && j == 0) return grid[i][j];
		return grid[i][j] + Math.max(auxMaxDivAndConq(i, j-1),auxMaxDivAndConq(i-1, j)); 
	}
	
	public int maxDivAndConqDP(){
		gridMaxSum = new int[nc][nc];
		maxCoins = auxMaxDivAndConqDP(nc-1, nc-1);
		return maxCoins;
	}

	private int auxMaxDivAndConqDP(int i, int j) {
		if(i < 0 || j < 0) return 0;
		if(i == 0 && j == 0) return grid[i][j];
		if(gridMaxSum[i][j] == 0) 
			gridMaxSum[i][j] = grid[i][j] + Math.max(auxMaxDivAndConqDP(i, j-1),auxMaxDivAndConqDP(i-1, j));
		return gridMaxSum[i][j]; 
	}
	
	private int maxLoopDP(){
		gridMaxSum = new int[nc][nc];
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				gridMaxSum[i][j] = grid[i][j] + Math.max(i == 0 ? 0 : gridMaxSum[i-1][j], j == 0 ? 0 : gridMaxSum[i][j-1]);
			}
		}
		return gridMaxSum[nc-1][nc-1];
	}
	
	/**
	 * Display max coins path using stack
	 */
	private void displayMaxCoinsPath(){
		Stack<String> stack = new Stack<String>();
		int i = nc-1,j = i;
		while(true){
			String index = "["+i+","+j+"]";
			if(i == 0 && j == 0){
				stack.add(index);
				break;
			}
			stack.add(index);
			if(i == 0)--j;
			else if(j == 0)--i;
			else{
				if(gridMaxSum[i-1][j] > gridMaxSum[i][j-1])--i;
				else --j;				
			}
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}
