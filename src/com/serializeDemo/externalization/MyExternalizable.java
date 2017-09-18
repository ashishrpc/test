package com.serializeDemo.externalization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
 * http://www.jusfortechies.com/java/core-java/externalization.php
 * 
 * When you want to control the process of reading and writing objects during the serialization and de-serialization process, 
 * have the object’s class implemented the java.io.Externalizable interface. Then you implement your own code to write object’s 
 * states in the writeExternal() method and read object’s states in the readExternal() method. These methods are defined by 
 * the Externalizable interface as follows:
 * 
	writeExternal(ObjectOutput out): The object implements this method to save its contents by calling the methods of DataOutput for 
	its primitive values or calling the writeObject method of ObjectOutput for objects, strings, and arrays.
 
	readExternal(ObjectInput in): The object implements this method to restore its contents by calling the methods of DataInput for 
	primitive types and readObject for objects, strings and arrays.
	
	VVI:How serialization happens? JVM first checks for the Externalizable interface and if object supports Externalizable interface, then serializes the object using writeExternal method. If the object does not support Externalizable but implement Serializable, then the object is saved using ObjectOutputStream. Now when an Externalizable object is reconstructed, an instance is created first using the public no-arg constructor, then the readExternal method is called. Again if the object does not support Externalizable, then Serializable objects are restored by reading them from an ObjectInputStream.
	
	Q. What will happen when an externalizable class extends a non externalizable super class?
	A. Then in this case, you need to persist the super class fields also in the sub class that implements Externalizable interface. 
	
	Q. Sounds good! What if the super class implements the Externalizable interface?
	A. In this case the super class will also have the readExternal and writeExternal methods as in Car class and will persist the respective fields in these methods.
 */
public class MyExternalizable {

	public static void main(String[] args) {
		// create a Car object 
		Car car = new Car("Mitsubishi", 2009);
		Car newCar = null;
		
		//serialize the car
		try {
		    FileOutputStream fo = new FileOutputStream("tmp");
		    ObjectOutputStream so = new ObjectOutputStream(fo);
		    so.writeObject(car);
		    so.flush();
		} catch (Exception e) {
		    System.out.println(e);
		    System.exit(1);
		}

		// de-serialize the Car
		try {
		    FileInputStream fi = new FileInputStream("tmp");
		    ObjectInputStream si = new ObjectInputStream(fi);  	    
		    newCar = (Car) si.readObject();
		}
		catch (Exception e) {
		    System.out.println(e);
		    System.exit(1);
		}

		/* 
		 * Print out the original and new car information
		 */
		System.out.println("The original car is ");
		System.out.println(car);
		System.out.println("The new car is ");
	    System.out.println(newCar);

	}

}

class Car implements Externalizable {
	public static final long serialVersionUID = 1234L;
    String name;
    int year;

    /*
     * mandatory public no-arg constructor
     */
    public Car() { super(); }
    
    Car(String n, int y) {
	name = n;
	year = y;
    }

    /** 
     * Mandatory writeExernal method. 
     */
    public void writeExternal(ObjectOutput out) throws IOException  {
	out.writeObject(name);
	out.writeInt(year);
    }

    /** 
     * Mandatory readExternal method. 
     */
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	name = (String) in.readObject();
	year = in.readInt();
    }

    /** 
     * Prints out the fields. used for testing!
     */
    public String toString() {
        return("Name: " + name + "\n" + "Year: " + year);
    }
}
