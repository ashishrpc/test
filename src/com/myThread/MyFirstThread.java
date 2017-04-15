package com.myThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyFirstThread extends Thread{
	private static int i=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList ar;
		LinkedList ll;
		HashMap hm;
		HashSet hs;
		
		String str="Ashish"; 
		// TODO Auto-generated method stub
		System.out.println("My First Thread...");
		MyFirstThread obj=new MyFirstThread();
		
		 obj.run(); 
	}
	public void run(){
		try{
		while(i<20){
			Thread.sleep(50);
			System.out.println(""+ ++i);
		}
		}catch(Exception e){}
	}
	
}
