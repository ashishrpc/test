package com.serializeDemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
/*
 * 

    The class must implement the java.io.Serializable interface.

    All of the fields in the class must be serializable. If a field is not serializable, it must be marked transient.
	all super class should be implements Serializable if you want to serialize that class
	
	VVI: How serialization happens? JVM first checks for the Externalizable interface and if object supports Externalizable interface, then serializes the object using writeExternal method. If the object does not support Externalizable but implement Serializable, then the object is saved using ObjectOutputStream. Now when an Externalizable object is reconstructed, an instance is created first using the public no-arg constructor, then the readExternal method is called. Again if the object does not support Externalizable, then Serializable objects are restored by reading them from an ObjectInputStream.
 */
public class Employee  extends person implements Serializable{

	public static final long serialVersionUID = 43084L;//It’s strongly recommended that all serializable classes define the serialVersionUID constant as declared in the class
														//This helps the de-serialization process keeps re-constructing the objects correctly when the serializable classes get changed overtime, and avoid the InvalidClassException.
	private String name;
	private String address;
	private transient int ssn;
	private int number;
	private NoneSerializable obj=new NoneSerializable();
	
	
	/*private Object readResolve()  {//readResolve is used for replacing the object read from the stream. The only use I've ever seen for this is enforcing singletons; when an object is read, replace it with the singleton instance. This ensures that nobody can create another instance by serializing (or Externalizable) and deserializing the singleton.
	    return obj;
	}*/
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
