package com;

import com.test.Test;

class StatBlock{
	
	public StatBlock(){
		System.out.println("StatBlock construction calling....");
	}
	
	
	{
		System.out.println("Intialize block....");
	}
	static{
		name="Static block";
		System.out.println("Static Block calling....");
	}
	private static String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
public class StaticBlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test test=new Test();
		StatBlock sb=new StatBlock();
		try{
		Class.forName("com.StatBlock");
		}catch(Exception e){}
		/*StatBlock sb=new StatBlock();
		sb.setName("set by first obj");
		StatBlock sb2=new StatBlock();
		System.out.println("get from 2nd obj : "+sb2.getName());
		String str="ABC";//Literal intern String
		String str1=new String("ABC");
		System.out.println(str1.concat("XYZ").intern());
		System.out.println(str1.intern());*/
	}

}
