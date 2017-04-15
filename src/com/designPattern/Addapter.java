package com.designPattern;

public class Addapter implements AddapterA, AddapterB {

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		System.out.println( "call me from A and B");
	}
	
}
