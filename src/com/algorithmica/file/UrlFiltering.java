package com.algorithmica.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.apache.cassandra.utils.*;

public class UrlFiltering {
	
	static final String inFile = "E:/bible/unsafeurls.txt";
	
	public static void main(String[] args) throws IOException {
		generateTestFile(Integer.parseInt(args[0]));
	}
	

	//using hash set
	
	
	//using bloom filter from cassandra jar
	public static boolean isUnSafeUrl(String url){
		BloomFilter.
		return false;
	}
	
	public static void generateTestFile(int n) throws IOException{
		Random r = new Random();
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(inFile)));
		for (int i = 0; i < n; i++) {
			bw.write("www."+UUID.randomUUID()+".com");
			bw.write("\n");
		}
		bw.close();
	}
}
