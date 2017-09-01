package com.immutable;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

import com.myInterface.Animal;
import com.myInterface.Cow;
import com.myInterface.Tiger;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;

/*
 Keep the following aspects in mind for creating your own immutable objects:
Make the fields final and initialize them in the constructor. For primitive types, the field values are final, there is no possibility of changing the state after it is initialized. For reference types, you cannot change the reference.
For reference types that are mutable, you need to take of some more aspects to ensure immutability. Why? Even if you make the mutable reference type final it is possible that the members may refer to objects created outside the class or may be referred by others. In this case:
Make sure that the methods don’t change the contents inside those mutable objects.
Don’t share the references outside the classes — for example, as a return value from methods in that class. If the references to fields that are mutable are accessible from code outside the class, they can end up modifying the contents of the object.
If you must return a reference, return the deep copy of the object (so that the original contents remain intact even if the contents inside the returned object is changed).
Provide only accessor methods (i.e., getter methods) but don’t provide mutator methods (i.e., setter methods)
In case changes must be made to the contents of the object, create a new immutable object with the necessary changes and return to that reference.
Declare the class final. Why? If the class is inheritable, methods in its derived class can override them and modify the fields.
=====================OR====================

Declare the class as final so it can’t be extended.
Make all fields private so that direct access is not allowed.
Don’t provide setter methods for variables
Make all mutable fields final so that it’s value can be assigned only once.
Initialize all the fields via a constructor performing deep copy.
Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference 
 
 * 
 */
//Observer design pattern : maintain state check on object.
interface MyInterface{
    public int sum();
}
abstract class MyAbs implements MyInterface{
    public int sum(){
        return 0;
    }
}
class Employee implements Comparable,Cloneable{
    private String name;
    private int age;
    static int count =0;
    public Employee(){//throws Exception{
//        if(count++==2){
//            throw new Exception("Object reach max...");
//        }
    }
    public Object clone() throws CloneNotSupportedException{
    	return super.clone();
    }
    public Employee(String str)throws Exception{  
        //this(); 
        this.name=str;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return this.name;
    }
    
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        Employee emp=(Employee)o;
        return name.compareTo(emp.getName());
    } 
}
 

public class MyImmutable  {//extends MyAbs implements MyInterface{ 
	public static void main(String[] args) { 

	}
	
   
}

final class Student{//Student class is immutable
    private final String name; 
    private final Employee employee;
    private final List<Employee> lstData;
    /*private Student(){
        
         * Multiple markers at this line
            - The blank final field lstData may not have been initialized
            - The blank final field name may not have been initialized
            - The blank final field employee may not have been initialized
         
    }*/
    public Student(String name, Employee employee)throws CloneNotSupportedException{
        this.name=name;
        this.employee=(Employee)employee.clone();//may be change from outside get it as clone
        this.lstData=new ArrayList<Employee>();
    }
    
    public String getName() {
        return name;
    }
    public Employee getEmployee() throws CloneNotSupportedException{
        return (Employee)employee.clone();//it should return colon / copy of this object. No one can change the state of this object
    }

    public List<Employee> getLstData() {
        return Collections.unmodifiableList(lstData);// throw exception if try to modify : java.lang.UnsupportedOperationException
    }
}
