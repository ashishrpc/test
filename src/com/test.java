package com;
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
class Employee implements Comparable{
    private String name;
    private int age;
    static int count =0;
    public Employee(){//throws Exception{
//        if(count++==2){
//            throw new Exception("Object reach max...");
//        }
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
    /*
    @Override
    public int compare(Object object1, Object object2) {
        // TODO Auto-generated method stub
        Employee emp1=(Employee)object1;
        Employee emp2=(Employee)object2;
        return emp1.getName().compareTo(emp2.getName());
    } 
     */
}
 
public class test  {//extends MyAbs implements MyInterface{ 
	public static void main(String[] args) { 
	    /*Integer a = 1000, b = 1000;  
	    System.out.println(a == b); // false  
	    Integer c = 100;  //-128 to 127
	    Integer d = 100;
	    System.out.println(c == d );*/
	    /*TreeMap<Employee, Employee>  obj1= new TreeMap<Employee, Employee>();
	    
	    try{
	    Employee e1=new Employee("a");
	    System.out.println(e1.getName());
        obj1.put(e1, e1);
	    e1=new Employee("a");
        obj1.put(e1, e1);
	    e1=new Employee("a");
	    obj1.put(e1, e1);
	    e1=new Employee("a");
	    obj1.put(e1, e1);
	    e1=new Employee("a");
	    obj1.put(e1, e1);
	    }catch (Exception e){
	        System.out.println("error: "+e);
	    }
	    System.out.println("success..."+obj1.toString());
	    */
	    /*Employee emp=new Employee();
	    emp.setName("Ram");
	    Student student=new Student("Ashish", emp);
	    student.getEmployee().setName("Shyam");//immutable fail// getter should return copy of another reference
	    student.getLstData();//.add(emp);//exception java.lang.UnsupportedOperationException
	    
	    System.out.println(student.getEmployee().getName());*/
	    

	}
	
   
}

final class Student{
    private final String name; 
    private final Employee employee;
    private final List<Employee> lstData;
    /*private Student(){
        
         * Multiple markers at this line
            - The blank final field lstData may not have been initialized
            - The blank final field name may not have been initialized
            - The blank final field employee may not have been initialized
         
    }*/
    public Student(String name, Employee employee){
        this.name=name;
        this.employee=employee;
        this.lstData=new ArrayList<Employee>();
    }
    
    public String getName() {
        return name;
    }
    public Employee getEmployee() {
        return employee;
    }

    public List<Employee> getLstData() {
        return Collections.unmodifiableList(lstData);// throw exception if try to modify : java.lang.UnsupportedOperationException
    }
}
