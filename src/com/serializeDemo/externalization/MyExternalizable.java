package com.serializeDemo.externalization;

/*
 * When you want to control the process of reading and writing objects during the serialization and de-serialization process, 
 * have the object’s class implemented the java.io.Externalizable interface. Then you implement your own code to write object’s 
 * states in the writeExternal() method and read object’s states in the readExternal() method. These methods are defined by 
 * the Externalizable interface as follows:
 * 
	writeExternal(ObjectOutput out): The object implements this method to save its contents by calling the methods of DataOutput for 
	its primitive values or calling the writeObject method of ObjectOutput for objects, strings, and arrays.
 
	readExternal(ObjectInput in): The object implements this method to restore its contents by calling the methods of DataInput for 
	primitive types and readObject for objects, strings and arrays.
 */
public class MyExternalizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
