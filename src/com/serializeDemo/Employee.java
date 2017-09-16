package com.serializeDemo;

import java.io.Serializable;
/*
 * 

    The class must implement the java.io.Serializable interface.

    All of the fields in the class must be serializable. If a field is not serializable, it must be marked transient.
	all super class should be implements Serializable if you want to serialize that class
 */
public class Employee  extends person implements Serializable{

	private String name;
	private String address;
	private transient int ssn;
	private int number;
	private NoneSerializable obj=new NoneSerializable();
	
	public NoneSerializable getObj() {
		return obj;
	}
	public void setObj(NoneSerializable obj) {
		this.obj = obj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void mailCheck(){
		System.out.println("Mailing a check to " + name + " " + address);
	}
	@Override
	public String toString(){
		return "Employee:: name: "+name+" address: "+address +" SSN : "+ssn+" Number: "+number+" Data:"+obj.getData()+" Data2:"+obj.getData2()+" ID:"+getId();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class person implements Serializable{
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
