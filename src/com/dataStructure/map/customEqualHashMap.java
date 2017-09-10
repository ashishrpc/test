package com.dataStructure.map;

import java.util.HashMap;
import java.util.Map;

public class customEqualHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map hmData2 =new HashMap<String,String>();//Map is a raw type. References to generic type Map<K,V> should be parameterized
		Map<String,String> hmData1 =new HashMap();
		/*(works with warning: 
		 * - Type safety: The expression of type HashMap needs unchecked conversion to conform to Map<String,String>
		  - HashMap is a raw type. References to generic type HashMap<K,V> should be parameterized)
		*/
		Map<Employee,String> hmData =new HashMap();
		Employee e1=new Employee();
		Employee e2=new Employee();
		Employee e3=new Employee();
		hmData.put(e1, "A");
		hmData.put(e2, "B");
		hmData.put(e3, "C");
		System.out.println(hmData.size()+" data :"+hmData.toString());
		System.out.println("e1: "+hmData.get(e2));
	}

}

class Employee{
	String id;
	String name;
	
	@Override
	public boolean equals(Object obj){
		return false;
	}
	@Override
	public int hashCode(){
		return 1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
