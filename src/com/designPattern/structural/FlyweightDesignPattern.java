package com.designPattern.structural;

import java.awt.Color;
import java.awt.Graphics;
/**
 * @author ashish.prasad
 * 
 * Flyweight design pattern is used when we need to create a lot of Objects of a class. 
 * Since every object consumes memory space that can be crucial for low memory devices, such as mobile devices or embedded systems, 
 * flyweight design pattern can be applied to reduce the load on memory by sharing objects
 * 
 * To apply flyweight pattern, we need to divide Object property into intrinsic and extrinsic properties. 
 * Intrinsic properties make the Object unique whereas extrinsic properties are set by client code and used to perform different operations. For example, an Object Circle can have extrinsic properties such as color and width.
 * 
 * Use: All the wrapper classes valueOf() method uses cached objects showing use of Flyweight design pattern. 
 * 		The best example is Java String class String Pool implementation.
 *
 *	Example: http://www.geeksforgeeks.org/flyweight-design-pattern/
 */

public class FlyweightDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="key managment group";
		String check="emg";
		int checkIndex=0;
		for(int i=0;i<str.length()-1;i++){
//			str.valueOf(arg0)
//			check.charAt(checkIndex)
		}
	}

	
}



interface Shape {

	public void draw(Graphics g, int x, int y, int width, int height,
			Color color);
}
