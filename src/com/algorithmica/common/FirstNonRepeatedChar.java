package com.algorithmica.common;

public class FirstNonRepeatedChar {
	
	public static void main(String[] args) {
		FirstNonRepeatedChar f = new FirstNonRepeatedChar();
		char c = f.find1(args[0]);
		System.out.println(c);		
	}
	
	public char find1(String str){
		int[] ascii = new int[1024];
		char[] charArray = str.toCharArray();
		char fnrc = 0;
		for (int i = charArray.length - 1; i >= 0; i--) {
			++ascii[(int)charArray[i]];
			if(ascii[(int)charArray[i]] == 1){
				fnrc = charArray[i];
			}
		}
		return ascii[(int)fnrc] == 1 ? fnrc : 0;
	}
	
}
