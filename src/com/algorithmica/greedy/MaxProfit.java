package com.algorithmica.greedy;

import java.util.Arrays;
import java.util.Random;

public class MaxProfit {

	static int bagSize;
	
	static int nItems; 
	
	static Item[] items;
	
	static Item[] mpItems;
	
	static int maxProfit;
	
	public static void main(String[] args) {
		loadItems(args);
		System.out.println("bag size : "+bagSize);
		display(items, nItems);
		maxProfit();
		System.out.println("maxProfit : "+maxProfit);
		display(mpItems, mpItems.length);
		System.out.println();
		System.out.println("Max ");
	}
	
	private static void display(Item[] pItems,int d) {
		int total = 0;
		for (int i = 0; i < d; i++) {
			System.out.println(pItems[i]+" profit : "+pItems[i].profit());
			total+=pItems[i].profit();
		}
		System.out.println("profit : "+total);
		System.out.println();
	}

	private static void maxProfit() {
		auxMaxProfit2(0,0,new Item[nItems],0);
	}

	public static int getRandom(int min,int max){
		int ran = 0;
		Random r = new Random();
		while(true){
			ran = r.nextInt(max);
			if(ran>=min) return ran;
		}		
	}
	
	public static void loadItems(String[] args){
		
		bagSize = Integer.parseInt(args[0]);
		nItems = Integer.parseInt(args[1]);
		items = new Item[nItems];
		for(int i = 0; i < nItems; i++){
			String itemName = "Item"+i;
			int itemCount = getRandom(10, 30);
			int itemProfit = getRandom(10, 20);
			Item item = new Item(itemName, itemCount, itemProfit);
			items[i] = item;
		}
		
	}
	
	public static void auxMaxProfit2(int d,int size,Item[] pItems,int profit){
		//display();
		//
		//return;
		if(d == nItems){
			//display(pItems,d);
			if(profit > maxProfit) {
				maxProfit = profit;
				mpItems = Arrays.copyOfRange(pItems, 0, d);
			}
			return;
		}
		
		for(int i = d; i < nItems; i++){
			Item item = items[i];
			if(isValid(pItems, item, d)){
				int tSize = size+item.itemCount;
				int tProfit = profit+(item.profit());
				if(tSize > bagSize){
					//display(pItems,d);
					if(profit > maxProfit) {
						maxProfit = profit;
						mpItems = Arrays.copyOfRange(pItems, 0, d);
					}
				}else{
					pItems[d] = item;
					auxMaxProfit2(d+1,tSize,pItems,tProfit);
				}				
			}			
		}
	}

	private static boolean isValid(Item[] pItems, Item item, int d) {
		boolean isValid = true;
		for (int i = 0; i < d; i++) {
			if(pItems[i].itemName==item.itemName){
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	
}
