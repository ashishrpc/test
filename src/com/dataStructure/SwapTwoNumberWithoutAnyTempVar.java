package com.dataStructure;

public class SwapTwoNumberWithoutAnyTempVar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SwapTwoNumberWithoutAnyTempVar(4,6);
	}

	public static void SwapTwoNumberWithoutAnyTempVar(int a, int b){
		System.out.println(a+" before "+b);
		a^=b;
		b^=a;
		a^=b;
		System.out.println(a+" after "+b);
	}
}
