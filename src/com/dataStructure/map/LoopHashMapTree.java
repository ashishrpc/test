package com.dataStructure.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class LoopHashMapTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Setting up a HashMap
		Map<String, String> cityMap = new HashMap<String, String>();//new TreeMap<String, String>()
		cityMap.put("1","New York City" );
		cityMap.put("2", "New Delhi");
		cityMap.put("3", "Newark");
		cityMap.put("4", "Newport");

		System.out.println("Looping with keySet");
		// First way with Key Set
		Set<String> citySet =  cityMap.keySet();
		for(String key : citySet){
			System.out.println("Key is " + key + " Value is " + cityMap.get(key));
		}

		System.out.println("Looping with entrySet");
		// Second way with entrySet
		for(Map.Entry<String, String> entry:  cityMap.entrySet()){
			System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());
		}

		System.out.println("Looping with entrySet using Iterator");
		//Third way with iterator
		Iterator<Entry<String, String>> itr =  cityMap.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, String> entry = itr.next();
			System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());
		}
		System.out.println("Looping with entrySet using Iterator with keyset()");
		//fourth way to iterator
		Set<String> keySet=cityMap.keySet();
		Iterator<String> it =keySet.iterator();
		while(it.hasNext()){
			String key=it.next();
			System.out.println(key+" : "+cityMap.get(key));
			/* Throw ConcurrentModivicationException : Fail-Fast
			 * if(key.equals("2")){
				cityMap.remove(key);
			}*/
		}
		Set hs=new HashSet();
		List ls=new ArrayList<String>(100);
		ls.add("aaaa"); 
		}

}
