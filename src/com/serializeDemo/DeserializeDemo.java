package com.serializeDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

class DeserializeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileInputStream fileInputStream=new FileInputStream("F:\\myEmplyee.txt");
			ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
			Employee emp=(Employee) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			System.out.println("Deserialized Employee...");
		    System.out.println(emp); 
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
	}

}
