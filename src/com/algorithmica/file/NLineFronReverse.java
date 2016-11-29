package com.algorithmica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class NLineFronReverse {

	static String fileLoc = "E:/workspace/bible/bible.txt";
	
	public static void main(String[] args) throws IOException {
		long st = 0;
		long et = 0;
		int n = Integer.parseInt(args[0]);
		st = System.currentTimeMillis();
		sol1(n);
		et = System.currentTimeMillis();
		System.out.println("sol1 :" +(et-st)/100.0);
		st = System.currentTimeMillis();
		sol2(n);
		et = System.currentTimeMillis();
		System.out.println("sol2 :" +(et-st)/100.0);
		st = System.currentTimeMillis();
		sol3(n);
		et = System.currentTimeMillis();
		System.out.println("sol3 :" +(et-st)/100.0);
	}
	
	public static void sol1(int n) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(new File(fileLoc)));
		int tLine = 0;
		String line = null;
		while((line = br.readLine()) != null){
			tLine++;
		}
		br.close();
		
		br = new BufferedReader(new FileReader(new File(fileLoc)));
		int i = 0;
		int nLine = tLine - (n);
		while((line = br.readLine()) != null){
			if(i++ == nLine){
				System.out.println(line);
				break;
			}
		}
		br.close();
	}
	
	public static void sol2(int n) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(fileLoc)));
		ArrayList<Integer> index = new ArrayList<Integer>();
		int ic = 0;
		int nchars = 0;
		while((ic = br.read()) != -1){
			nchars++;
			if(ic == 10){
				index.add(nchars);
			}			
		}
		br.close();
		int nLines = index.size();
		//System.out.println(index);
		br = new BufferedReader(new FileReader(new File(fileLoc)));
		br.skip(index.get(nLines - n));
		String line = null;
		if((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}
	
	public static void sol3(int n) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(fileLoc)));
		ArrayList<Integer> index = new ArrayList<Integer>();
		String line = null; 
		int nchars = 0;
		while((line = br.readLine()) != null){
			nchars += line.length()+2;			
			index.add(nchars);
		}
		br.close();
		int nLines = index.size();
		//System.out.println(index);
		br = new BufferedReader(new FileReader(new File(fileLoc)));
		br.skip(index.get(nLines - (n+1)));
		line = null;
		if((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}
	
	public static void reverseFileReaderSol() throws IOException{
		ReversedLinesFileReader rfr = new ReversedLinesFileReader(new File(fileLoc), 4096,
		        Charset.forName("UTF-8"));
	}
}
