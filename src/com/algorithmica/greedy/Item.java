package com.algorithmica.greedy;

public class Item{
	public String itemName;
	public int itemCount;
	public int itemProfit;
	public Item(String itemName, int itemCount, int itemProfit) {
		super();
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemProfit = itemProfit;
	}
	@Override
	public String toString() {
		return "Item [Name=" + itemName + ", C =" + itemCount + ", P=" + itemProfit + "]";
	}	
	public int profit(){
		return this.itemCount*this.itemProfit;
	}
}