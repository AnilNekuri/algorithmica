package com.algorithmica.greedy;

public class EditDistance {

	String s1 = null;
	String s2 = null;	
	
	int[][] mem;
	
	
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		ed.s1 = args[0];
		ed.s2 = args[1];
		int editDistanceRec = ed.editDistanceRec(ed.s1, ed.s2);
		ed.mem = new int[ed.s1.length()][ed.s2.length()];
		System.out.println(editDistanceRec);
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
	
	//memory bases solution
	
	
}
