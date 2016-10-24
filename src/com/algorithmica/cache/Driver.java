package com.algorithmica.cache;

import java.util.Random;
import java.util.UUID;

public class Driver {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		LinkedHashCache<String, Integer> lhc = new LinkedHashCache<String, Integer>(n);
		Random r = new Random();
		// set.add(1000);
		for (int i = 0; i < n; i++) {
			lhc.put(UUID.randomUUID().toString(), r.nextInt(1000));
		}
		lhc.put("4a1f5a29-e9e8-4865-bee9-5cbe1634b8aa", 100);
		System.out.println(lhc.display()+"\n"+lhc.size());
		lhc.put("4a1f5a29-e9e8-4865-bee9-5cbe1634b8aa", 200);
		System.out.println(lhc.display()+"\n"+lhc.size());
		lhc.put(UUID.randomUUID().toString(), r.nextInt(1000));
		System.out.println(lhc.display()+"\n"+lhc.size());
		lhc.put(UUID.randomUUID().toString(), r.nextInt(1000));
		System.out.println(lhc.display()+"\n"+lhc.size());		
	}
}