package com.algorithmica.backtracking;

public class Sudoku {
	
	static int[][] sudoArr = new int[9][9];
	
	public static void main(String[] args) {
		sudo1();	
	}
	
	public static void sudo1(){
		for(int is = 0,ix = 2; is < 9 && ix < 9; is += 3,ix += 3){
			for(int js = 0, jx = 2; js < 9 && jx < 9;js += 3,jx += 3 ){
				System.out.println("i -> ("+is+"-"+ix+") , j -> ("+js+"-"+jx+")");
				fill3x3Block(is, ix, js, jx);
			}
			if(sudoArr[8][8] != 0){
				display();
				sudoArr[8][8] = 0;
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

	public static void fill3x3Block(int is,int ix,int js,int jx){
		int[] block = new int[9];
		int index = 0;
		for(int i = is; i <= ix; i++){
			for(int j = js; j <= jx; j++){
				for(int k = 1; k <= 9; k++){
					if(isValid(block,i,j,k)){
						block[index] = k;
						sudoArr[i][j] = k;
						index++;
						break;
					}
				}
			}
		}
	}

	private static boolean isValid(int[] block, int i, int j,int k) {
		boolean isValid = true;
		for(int b = 0; b < block.length && block[b] != 0; b++){
			if(k == block[b]){
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
