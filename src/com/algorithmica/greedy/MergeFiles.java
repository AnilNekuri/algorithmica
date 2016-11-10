package com.algorithmica.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class MergeFiles {

	int minFm = 0;
	
	LinkedList<Integer> list = new LinkedList<Integer>();
	int n = 0;
	
	public static void main(String[] args) {
		MergeFiles mf = new MergeFiles();
		mf.n = Integer.parseInt(args[0]);
		Random r = new Random();
		for(int i = 0; i < mf.n; i++){
			mf.list.add(getRandom());			 
		}
		Collections.sort(mf.list);
		System.out.println(mf.list);
		int greedyMerge = mf.greedyMerge();
		int adhocMerge = mf.adhocMerge();
		System.out.println("greedy style merge count : "+greedyMerge);
		System.out.println("adhoc style merge count : "+adhocMerge);
	}
	
	public static int getRandom(){
		int ran = 0;
		Random r = new Random();
		while(true){
			ran = r.nextInt(10);
			if(ran>0) return ran;
		}		
	}
	
	public int greedyMerge(){
		int f1c = 0;
		int f2c = 0; 				
		int fileMerges = 0;
		@SuppressWarnings("unchecked")
		LinkedList<Integer> clist = (LinkedList<Integer>) list.clone();
		while(!clist.isEmpty()){			
			f1c = clist.remove(0);
			f2c = !clist.isEmpty()?clist.remove(0):0;
			fileMerges += f1c+f2c;
			if(clist.isEmpty()) break;
			clist.add(f1c+f2c);
			Collections.sort(clist);
		}		
		return fileMerges;
	}
	
	public int adhocMerge(){		
		auxAdhocMerge(list.clone(), 0);			
		return minFm;
	}
	
	@SuppressWarnings("unchecked")
	private void auxAdhocMerge(Object object, int fileMerges) {
		int f1c = 0;
		int f2c = 0;
		LinkedList<Integer> clist = (LinkedList<Integer>) object;
		for (int i = 0; i < clist.size(); i++) {
			for (int j = i + 1; j < clist.size(); j++) {
				LinkedList<Integer> tmp = (LinkedList<Integer>) clist.clone();
				int fmtmp = fileMerges;
				f2c = tmp.size() >= j ? tmp.remove(j) : 0;
				f1c = tmp.remove(i);				
				fmtmp += f1c + f2c;
				if (tmp.isEmpty()) {
					if(minFm == 0 || minFm > fmtmp) minFm = fmtmp;
					System.out.println("Adhoc count : "+fmtmp);
				} else {
					tmp.add(f1c + f2c);
					auxAdhocMerge(tmp, fmtmp);
				}

			}
		}
	}
}
