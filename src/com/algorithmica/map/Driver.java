package com.algorithmica.map;

import java.util.Random;
import java.util.UUID;

public class Driver {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		IMap<String,Integer> map = new HashMap<String,Integer>();
		Random r = new Random();
		//set.add(1000);
		for(int i = 0; i < n; i++){
			map.put(UUID.randomUUID().toString(),r.nextInt(1000));
		}	
		map.put("4a1f5a29-e9e8-4865-bee9-5cbe1634b8aa", 100);
		System.out.println(map.display());
		System.out.println(map.size());
		map.remove("4a1f5a29-e9e8-4865-bee9-5cbe1634b8aa");
		System.out.println(map.display());
		System.out.println(map.size());
	}
}
