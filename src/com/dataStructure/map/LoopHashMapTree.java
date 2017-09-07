package com.dataStructure.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LoopHashMapTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Setting up a HashMap
		Map<String, String> cityMap = new HashMap<String, String>();//new TreeMap<String, String>()
		cityMap.put("1","NewYorkCity" );
		cityMap.put("3", "Japan");
		cityMap.put("4", "Newport");
		cityMap.put("2", "Delhi");
		
		

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
		System.out.println("==================Sorting by key==================");
		Map<String,String> map=new TreeMap<String,String>(cityMap);
		for(Map.Entry<String, String> entry:  map.entrySet()){
			System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());
		}
		System.out.println("==================Sorting by Value==================");
		List lst=new LinkedList<Map.Entry<String, String>>(cityMap.entrySet());
		Collections.sort(lst,new Comparator() {
			@Override
			public int compare(Object o1,Object o2){
				return ((Comparable)((Map.Entry) o1).getValue()).compareTo((Comparable)((Map.Entry)o2).getValue());
			}
		});
		System.out.println("List: "+lst);
		for(Iterator it1=lst.iterator();it1.hasNext();){
			Map.Entry entry=(Map.Entry)it1.next();
			System.out.println("key: "+entry.getKey()+";; Value: "+entry.getValue());
		}
	}

	/*class A{
		
		public void AA(){
			System.out.println("This is A");
		}
	}
	
	class B extends A{
		public B(){
			super();
			
			System.out.println("This is A");
			this.fun();
		}
		
		public B(int i){
			//super();
			//this();
			super.AA();
			System.out.println("This is A");
			this.fun();
		}
		public void fun(){
			
		}
		public void fun2(){
			int i=0;
			i++;
			this.fun();
		}
	}*/


}
