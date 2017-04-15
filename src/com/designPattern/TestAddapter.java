package com.designPattern;

public class TestAddapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddapterA objAddapter=new Addapter();
		AddapterB objAddapterB=(AddapterB)objAddapter;
		objAddapter.fun();
		objAddapterB.fun();
		System.out.println("Pass multiple inheritance.....");
	}

}
