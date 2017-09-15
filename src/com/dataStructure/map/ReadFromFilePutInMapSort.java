package com.dataStructure.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * good example
 */
public class ReadFromFilePutInMapSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
		File file= new File("G:\\arpc\\readMe.txt");
		FileInputStream fis= new FileInputStream(file);
		int content=0;
		StringBuilder sb=new StringBuilder();
		while((content=fis.read())!=-1){
			sb.append((char)content);
		}
		System.out.println("FileInputStream :\n"+sb.toString());
		sb=new StringBuilder();
		BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
		String line;
		while((line=bufferedReader.readLine())!=null){
			sb.append(line);			
		}
		System.out.println("BufferedReader :\n"+sb.toString());
		Map<String, Integer> hmData=new HashMap<>();
		String[] countryArr= sb.toString().split(",");
		for(String country:countryArr){
			if(hmData.containsKey(country)){
				hmData.put(country, hmData.get(country) + 1);
			}else{
				hmData.put(country, 1);
			}
		}
		System.out.println(hmData);
		System.out.println("======Sorting by key======");
		TreeMap<String, Integer> treeMap=new TreeMap<>(hmData);
		System.out.println(treeMap);
		System.out.println("======Sorting by value======");
		List<Map.Entry<String,Integer>> linkedList=new LinkedList<Map.Entry<String,Integer>>(hmData.entrySet());
		Collections.sort(linkedList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1,Map.Entry<String, Integer> e2){
				return e1.getValue().compareTo(e2.getValue());
				
			}
		});
		System.out.println(linkedList);
		}catch(Exception ioe){
			ioe.printStackTrace();
		}
	}

}
