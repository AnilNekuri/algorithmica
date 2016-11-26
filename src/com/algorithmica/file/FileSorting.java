package com.algorithmica.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FileSorting {

	static String inFile = "in_numbers.txt";
	static String outFile = "out_numbers.txt";
	
	public static void main(String[] args) throws IOException {
		generateTestFile(Integer.parseInt(args[0]));
	}
	
	public static void adhocSort() throws IOException{
		List<Integer> numbers = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(new File(inFile)));
		String line;
		while((line = br.readLine()) != null){
			numbers.add(Integer.parseInt(line));
		}
		Collections.sort(numbers);
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(outFile)));
		for (Integer integer : numbers) {
			bw.write(integer);
		}
		bw.close();
	}
	
	public static void generateTestFile(int n) throws IOException{
		Random r = new Random();
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(inFile)));
		for (int i = 0; i < n; i++) {
			bw.write(String.valueOf(r.nextInt(n)));
			bw.write("\n");
		}
		bw.close();
	}
}
