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
