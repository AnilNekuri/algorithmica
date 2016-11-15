package com.algorithmica.greedy;

import java.util.Arrays;

public class EditDistance {

	String s1 = null;
	String s2 = null;	
	
	int[][] mem;
	
	
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		ed.s1 = args[0];
		ed.s2 = args[1];		
		ed.mem = new int[ed.s1.length()][ed.s2.length()];
		for (int i = 0; i < ed.mem.length; i++) {
			Arrays.fill(ed.mem[i],-1);
		}
		int editDistanceRec = ed.editDistanceRecDp(ed.s1, ed.s2);
		System.out.println(editDistanceRec);
		int editDistanceL = ed.editDistanceLoopDP(ed.s1, ed.s2);
		System.out.println(editDistanceL);
	}
	
	//replace , delete , insert
	private int auxEditDistanceRec(int i,int j,String s1,String s2){
		int rDist=0,dDist=0,iDist=0;
		if(i<0 && j < 0) return 0;
		if(i<0) return j+1;
		if(j<0) return i+1;

		if(s1.charAt(i) != s2.charAt(j)) rDist = 1;
		rDist += auxEditDistanceRec(i-1, j-1, s1, s2);
		dDist = 1 + auxEditDistanceRec(i-1, j, s1, s2);
		iDist = 1 + auxEditDistanceRec(i, j-1, s1, s2);
		return Math.min(rDist,Math.max( dDist,iDist));
	}
	
	public int editDistanceRec(String s1,String s2){
		int d = auxEditDistanceRec(s1.length()-1, s2.length()-1, s1, s2);
		return d;
	}
	
	//replace , delete , insert
	private int auxEditDistanceRecDp(int i, int j, String s1, String s2) {
		int rDist = 0, dDist = 0, iDist = 0;
		if (i < 0 && j < 0)
			return 0;
		if (i < 0)
			return j + 1;
		if (j < 0)
			return i + 1;
		if (mem[i][j] == -1) {
			if (s1.charAt(i) != s2.charAt(j))
				rDist = 1;
			rDist += auxEditDistanceRecDp(i - 1, j - 1, s1, s2);
			dDist = 1 + auxEditDistanceRecDp(i - 1, j, s1, s2);
			iDist = 1 + auxEditDistanceRecDp(i, j - 1, s1, s2);
			mem[i][j] = Math.min(rDist, Math.min(dDist, iDist));
		}
		return mem[i][j];
	}
	
	//memory bases solution
	public int editDistanceRecDp(String s1,String s2){
		int d = auxEditDistanceRecDp(s1.length()-1, s2.length()-1, s1, s2);
		return d;
	}	
	
	public int editDistanceLoopDP(String s1,String s2){	
		int rDist = 0;
		int dDist = 0;
		int iDist = 0;
		int min = 0;
		int max = s1.length() + s2.length();
		for(int i = 0; i < s1.length(); i++){
			for(int j = 0; j < s2.length(); j++){
				rDist = ((i-1) < 0 && (j-1) < 0) ? 0 : ((i-1) < 0 || (j-1) < 0) ? max  : mem[i-1][j-1];
				dDist = ((i-1) < 0) ? max : mem[i-1][j];
				iDist = ((j-1) < 0) ? max : mem[i][j-1];
				min = Math.min(rDist,Math.min(dDist, iDist));
				if(s1.charAt(i) != s2.charAt(j)) mem[i][j] = 1 + min;				
				else mem[i][j] = min;
			}
		}
		return mem[s1.length()-1][s2.length()-1];
	}
}
