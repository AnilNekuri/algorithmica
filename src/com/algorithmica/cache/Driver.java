package com.algorithmica.cache;

import java.util.Random;
import java.util.UUID;

import com.algorithmica.map.HashMap;
import com.algorithmica.map.IMap;

public class Driver {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		LinkedHashCache<String, Integer> lhc = new LinkedHashCache<String, Integer>(10);
		Random r = new Random();
		// set.add(1000);
		for (int i = 0; i < n; i++) {
			lhc.put(UUID.randomUUID().toString(), r.nextInt(1000));
		}
		lhc.put("4a1f5a29-e9e8-4865-bee9-5cbe1634b8aa", 100);
		System.out.println(lhc.display());
		lhc.put("4a1f5a29-e9e8-4865-bee9-5cbe1634b8aa", 200);
		System.out.println(lhc.display());
		lhc.put(UUID.randomUUID().toString(), r.nextInt(1000));
		System.out.println(lhc.display());
		lhc.put(UUID.randomUUID().toString(), r.nextInt(1000));
		System.out.println(lhc.display());
		System.out.println(lhc.size());
		
	}
}