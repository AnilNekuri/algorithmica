package com.algorithmica.backtracking;

public class Sudoku {
	
	static int[][] indexOrder = new int[81][2]; 
	
	static int[][] sudoArr = new int[9][9];
	
	public static void main(String[] args) {
		sudo();		
	}
	
	public static void sudo(){
		createOrder();
		fillSudo(0);
	}
	
	public static void fillSudo(int i){
		if(i == 81){
			display();
			System.out.println();
			return;
		}
		for(int n = 1; n <= 9; n++){	
			if(isValid2(i, indexOrder[i][0], indexOrder[i][1], n)){
				sudoArr[indexOrder[i][0]][indexOrder[i][1]] = n;
				fillSudo(i+1);
			}			
		}
	}
	
	private static boolean isValid2(int oIndex, int i, int j,int k) {
		boolean isValid = true;
		for(int b = (oIndex/9)*9; b < oIndex; b++){
			if(k == sudoArr[indexOrder[b][0]][indexOrder[b][1]]){
				isValid = false;
				break;
			}
		}
		if(!isNotExistInRow(k, i,j)){
			isValid = false;
		}
		if(!isNotExistInColumn(k, i,j)){
			isValid = false;
		}
		return isValid;
	}
	
	
	public static void createOrder(){
		int index = 0;
		for(int is = 0,ix = 2; is < 9 && ix < 9; is += 3,ix += 3){
			for(int js = 0, jx = 2; js < 9 && jx < 9;js += 3,jx += 3 ){
				for(int x = is; x <= ix; x++){
					for(int y = js; y <= jx; y++){
						int[] tmp = new int[2]; 
						tmp[0] = x;
						tmp[1] = y;
						indexOrder[index] = tmp;
						index++;
					}
				}
			}			
		}
	}
	
	private static void display() {
		for(int i = 0; i < 9; i++){			
			for(int j = 0; j < 9; j++){	
				System.out.print(" "+sudoArr[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean isNotExistInColumn(int k,int i, int j) {
		boolean isValid = true;
		for(int e = 0; e < i; e++){
			if(sudoArr[e][j] == k){
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	private static boolean isNotExistInRow(int k, int i,int j) {
		boolean isValid = true;
		for(int e = 0; e < j; e++){
			if(sudoArr[i][e] == k){
				isValid = false;
				break;
			}
		}
		return isValid;
	}
}
