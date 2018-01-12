package com.test;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class Foo {
	private  int i = 3;
	public Foo(){
		
	}
	public Foo(int i){
		//this.i=i;
	}
	public String toString(){
		return i+"";
	}
	}
public class Test {
	public Test(){
		System.out.println("Test() constractor calling....");
	}
	private static Test test=new Test();
	public static void main(String args[]) {
		Map<String, Foo> obj=new HashMap<String, Foo>();
		obj.put("a", new Foo());
		obj.put(null, null);
		obj.put(null, new Foo());
		System.out.println(obj);
		Map<String, Foo> objht=new Hashtable<String, Foo>();
		//objht.put(null, new Foo());
		objht.put("nn", null);
		System.out.println(objht);
	}
	
	
}
class A {public A(){}
	B b;
}
class B {public B(){}
	A a;
}
class C {
	Integer i;
	
	public C(){}
	
	public void fun(List<Integer> li){}
	//public void fun(List<String> li){} //compile error:Erasure of method fun(List<String>) is the same as another method in type C
	//test Commit....
}