package com.serializeDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		NoneSerializable obj =new NoneSerializable();
		emp.setName("Ashish");
		emp.setAddress("Vaishali");
		emp.setSsn(555);
		emp.setNumber(55);
		obj.setData("Data");
		obj.setData2("Data2");
		emp.setObj(obj);
		System.out.println(emp);
		try{
			FileOutputStream fileOutputStream=new FileOutputStream("F:\\myEmplyee.txt");
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(emp);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("file written to given location.....");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}
