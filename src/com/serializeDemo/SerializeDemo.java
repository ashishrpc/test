package com.serializeDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/*
 * Serialization is the process of converting an object's state (including its references) to a sequence of bytes, as well as the process 
 * of rebuilding those bytes into a live object at some future time. Serialization can be achieved by an object by implementing 
 * Serializable interface or Externalizable interface.
 * 
 * =====OR====
 * In serialization, the Java Virtual Machine is totally responsible for the process of writing and reading objects. This is useful in
 *  most cases, as the programmers do not have to care about the underlying details of the serialization process. However, 
 *  the default serialization does not protect sensitive information such as passwords and credentials, or what if the programmers 
 *  want to secure some information during the serialization process? (Thus externalization comes to give the programmers full control in reading and writing objects during serialization)
 *  
 */
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
		emp.setId("MyID");
		obj.setData("Data");
		obj.setData2("Data2");
		
		emp.setObj(obj);/// if obj is not implemented serializable interface::: java.io.NotSerializableException: com.serializeDemo.NoneSerializable
		System.out.println(emp);
		try{
			FileOutputStream fileOutputStream=new FileOutputStream("H:\\myEmplyee.txt");
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
