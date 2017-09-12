package com.java8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 *  It provides a clear and concise way to represent one method interface using an expression.
 *  It is very useful in collection library. It helps to iterate, filter and extract data from collection. 
 *  Before lambda expression, anonymous inner class was the only option to implement the method.
 *  
 *  In other words, we can say it is a replacement of java inner anonymous class. Java lambda expression is treated as a function, so compiler does not create .class file.
 *  
 *  Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface. Java provides an anotation @FunctionalInterface,
 *
 *In single line description, Interface with only abstract method are referred as Functional Interface. However, 
 *A functional interface can have more than one static or default methods, and also can Override some methods from java.lang.Object
 */
@FunctionalInterface
interface LambdaInterface{
	// Only abstract method
	public int arithmatic(int a, int b);
	// Functional interface can have more than one static or default methods.
	default public void fun(){
		System.out.println("default function of interface");
	}
	static public void funStatic(){
		System.out.println("Static function of interface");
	}
	// And also can override methods of java.lang.Object	   
	@Override
	public String toString();
}
public class LambdaExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaInterface str=(a,b)-> {return a+b;};
		System.out.println(""+str.arithmatic(10,20));
		str.fun();
		LambdaInterface.funStatic();
		List<Student> lst=new ArrayList();
		lst.add(new Student("102","ram",29));
		lst.add(new Student("105","ashish",25));
		lst.add(new Student("109","pam",21));
		Collections.sort(lst,(s1,s2)-> s1.getName().compareTo(s2.getName()));
		Iterator<Student> it=lst.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		System.out.println("========forEach for list to retrive objects===============");
		lst.forEach( s -> System.out.println(s.toString()));
		System.out.println("========forEach method reference===============");
		lst.forEach(System.out::println);
		System.out.println("========stream and filter===============");
		lst.stream()
			.filter(s->(s.getAge()==25))
			.forEach(System.out::println);;
		System.out.println("========forEach for map to retrive objects for key value===============");
		
		Map<String,Student> hmData=new HashMap();
		hmData.put("102",new Student("102","ram",29));
		hmData.put("105",new Student("105","ashish",25));
		hmData.put("106",new Student("109","pam",21));
		hmData.forEach((k, v)->System.out.println("Key: "+k+"; Value: "+v.toString()));
		
		
	}

}
class Student{
	private String id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String name;
	private int age;
	public Student(){
		
	}
	public Student(String id, String name, int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString(){
		return this.id+"; "+this.name+"; "+this.age;
	}
}
