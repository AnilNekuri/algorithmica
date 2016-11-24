package com.algorithmica.sorting;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Sorting {

	public static void treeSort(final int[] arr){
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			ts.add(arr[i]);
		}
		for(int i = 0; i < arr.length; i++){
			arr[i] = ts.pollFirst();
		}
	}
	
	//heap sort
	public static void heapSort(int[] inArr){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < inArr.length; i++){
			pq.add(inArr[i]);
		}
		for(int i = 0; i < inArr.length; i++){
			inArr[i] = pq.poll();
		}
	}
	
	//inertion sort
	public static void insertionSort(final int[] inArr){
		if(inArr.length > 1){
			for(int i = 1; i < inArr.length; i++){
				int current = inArr[i];
				int j = 0;
				for(j = i-1; j >= 0;j--){
					if(current < inArr[j]){
						inArr[j+1] = inArr[j] ;
					}else
						break;
				}
				inArr[j+1] = current;
			}
		}		
	}
	
	public static void mergeSort(final int[] inArr){
		int li = 0;
		int ui = inArr.length-1;
		auxMergeSort(inArr, li, ui);
	}
	
	private static void auxMergeSort(int[] inArr,int li,int ui){
		if(li == ui)
			return;
		int ui1 = li + (ui-li)/2;
		int li2 = ui1+1;

		auxMergeSort(inArr, li, ui1);
		auxMergeSort(inArr, li2, ui);
		merge(inArr, li, ui1, li2, ui);
	}
	
	private static void merge(int[] inArr,int li1,int ui1,int li2,int ui2){
		int[] tmp =new int[ui2-li1+1];
		int i = li1;
		int j = li2;
		int k = 0;
		while(i <= ui1 && j <= ui2){
			int a1 = inArr[i];
			int a2 = inArr[j];
			if(a1 > a2){
				tmp[k++] = a2;
				j++;		
			}		
			else {
				tmp[k++] = a1;
				i++;
			}	
			
		}
		if(i <= ui1)
			while(k < tmp.length && i <= ui1){
				tmp[k++] = inArr[i++];
				
			}
		
		if(j <= ui2)
			while(k < tmp.length && i <= ui2){
				tmp[k++] = inArr[j++];
			}
		
		for(k = 0; k < tmp.length; k++){
			inArr[k+li1] = tmp[k];
		}
	}
}
