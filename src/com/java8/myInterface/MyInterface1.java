package com.java8.myInterface;
/*
 * Java 8 introduces “Default Method” or (Defender methods)
 * ‘List’ or ‘Collection’ interfaces do not have ‘forEach’ method declaration. Java 8 introduces default method so that List/Collection interface can have a default implementation of forEach method.
 */
interface MyInterface {
	default public void fun(){
		System.out.println("MyInterface->fun()");
	}
	
	static void staticFun(){
		System.out.println("MyInterface->staticFun()");
	}
}
interface MyInterface2 {
	default public void fun(){
		System.out.println("MyInterface2->fun(int id)");
	}
}
//Multiple Inheritance Ambiguity Problems
// error compile time:::java: class Impl inherits unrelated defaults for defaultMethod() from types InterfaceA and InterfaceB
//First solution is to create an own method that overrides the default implementation.
//Second solution is to call the default method of the specified interface using super:: MyInterface.super.fun();
class MyIntefaceImpl implements MyInterface,MyInterface2{
	public void fun(){
		System.out.println("MyIntefaceImpl->fun()");
		MyInterface.super.fun();
		MyInterface2.super.fun();
	}
}
public class MyInterface1 {
	public static void main(String args[]){
		MyInterface obj1=new MyIntefaceImpl();
		obj1.fun();
	}
}