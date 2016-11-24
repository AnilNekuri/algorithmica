package com.algorithmica.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Sorting {

	static Random r = new Random();
	
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
	
	public static void quickSort(int[] inArr){
		auxQuickSort(inArr,0,inArr.length-1);
	}

	private static void auxQuickSort(int[] inArr, int l, int u) {
		if(l >= u)
			return;
		int p = partion(inArr,l,u);
		auxQuickSort(inArr, l, p-1);
		auxQuickSort(inArr, p+1, u);		
	}
	
	private static void swap(final int[] arr,int ci, int pi) {
		if(ci == pi) return;
		int tmp = arr[ci];
		arr[ci] = arr[pi];
		arr[pi] = tmp;
	}
	
	private static int partion1(int[] inArr, int l, int u) {
		int pivotIndex = l;
		int pivot = inArr[pivotIndex];
		int lastMin = l;
		for(int i = l; i <= u; i++){
			if(pivot > inArr[i]){
					lastMin++;					
				if(inArr[lastMin] > pivot)
					swap(inArr, lastMin, i);
			}										
		}		
		swap(inArr, pivotIndex, lastMin);
		return lastMin;
	}
	
	//pivot index as startin element
	//pivot index as random element
	//pivot index as meadian of three
	private static int partion(int[] inArr, int l, int u) {
		int pivotIndex = medianOf3(l, u);
		int pivot = inArr[pivotIndex];
		int lastMin = -1;
		for(int i = l; i <= u; i++){
			if(pivot > inArr[i]){
					if(lastMin != -1)lastMin++;
					else lastMin = l;		
					if(lastMin == pivotIndex) lastMin++;
					swap(inArr, lastMin, i);
			}										
		}
		if(lastMin < pivotIndex){
			if(lastMin != -1)lastMin++;
			else lastMin = l;		
		}
//		System.out.println("l : "+l+" , u : "+u);
//		System.out.println("p : "+pivotIndex+" , value : "+pivot);
//		System.out.println("m : "+lastMin+" , value : "+inArr[lastMin]);
//		System.out.println("Bfr : "+Arrays.toString(Arrays.copyOfRange(inArr, l, u)));
		swap(inArr, pivotIndex, lastMin);
//		System.out.println("Aft : "+Arrays.toString(Arrays.copyOfRange(inArr, l, u)));
//		System.out.println();
		return lastMin;
	}
	
	private static int medianOf3(int l, int u) {
		int median = 0;
		int rint = r.nextInt(3);
		int m = (u - l)/2 + l;
		switch(rint){
			case 0: median =  (m - l)/2 + l;break;
			case 1: median =  (u - m)/2 + m;break;
			case 2: median =  (u - l)/2 + l;break;
		}
		return median;
	}

	//HybridSort
	private static void HybridSort(int[] inArr){
		//mix multiple sorts
		//combination of sorting techniques
	}
	
}
