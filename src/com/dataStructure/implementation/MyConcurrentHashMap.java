package com.dataStructure.implementation;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyConcurrentHashMap extends HashMap {

	private Lock putLock = new ReentrantLock();
	
	@Override
	public Object put(Object key, Object value){
		putLock.lock();
		try{
		return super.put(key, value);
		}catch(Exception ex){
			
		}finally{
			putLock.unlock();
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConcurrentHashMap hm=new MyConcurrentHashMap();
		hm.put("key", "Ashish");
		System.out.println(hm.get("key"));
	}

}
