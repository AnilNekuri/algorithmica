package com.algorithmica.backtracking;

public class Sudoku {
	
	static int[][] indexOrder = new int[81][2]; 
	
//	static int[][] sudoArr = {
//								{0,2,6,0,0,9,5,7,0},
//								{3,5,0,0,7,6,1,4,0},
//								{0,7,1,8,0,3,9,0,0},
//								{7,1,0,0,0,5,6,8,0},
//								{5,0,0,6,8,0,0,1,4},
//								{2,0,8,1,4,0,0,0,9},
//								{6,8,2,0,9,0,0,0,7},
//								{0,0,7,0,6,0,2,9,5},
//								{9,0,0,7,0,4,0,0,1}
//			
//							};
	
	static int[][] sudoArr = {
			{0,0,0,0,0,3,0,0,0},
			{0,0,0,0,0,0,7,0,1},
			{1,0,0,0,8,0,5,4,0},
			{0,5,6,0,1,9,0,0,4},
			{9,0,0,0,0,0,0,0,8},
			{3,0,0,6,5,0,1,7,0},
			{0,1,8,0,4,0,0,0,7},
			{7,0,3,0,0,0,0,0,0},
			{0,0,0,9,0,0,0,0,0}

		};
	
	public static void main(String[] args) {
		sudo();		
	}

	
	public static void sudo(){
		createOrder();
//		for (int i = 0; i < indexOrder.length; i++) {
//			System.out.println(i+"- "+Arrays.toString(indexOrder[i]));
//		}
		
		fillSudo(0);
	}
	
	public static void fillSudo(int i){
		if(i == 81){
			display();
			System.out.println();
			return;
		}
		if(sudoArr[indexOrder[i][0]][indexOrder[i][1]] != 0){
			fillSudo(i+1);
		}else{
			for(int n = 1; n <= 9; n++){	
				if(isValid2(i, indexOrder[i][0], indexOrder[i][1], n)){
					sudoArr[indexOrder[i][0]][indexOrder[i][1]] = n;
					fillSudo(i+1);
				}			
			}
			sudoArr[indexOrder[i][0]][indexOrder[i][1]] = 0;
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
		for(int e = 0; e < 9; e++){
			if(sudoArr[e][j] == k){
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	private static boolean isNotExistInRow(int k, int i,int j) {
		boolean isValid = true;
		for(int e = 0; e < 9; e++){
			if(sudoArr[i][e] == k){
				isValid = false;
				break;
			}
		}
		return isValid;
	}
}
