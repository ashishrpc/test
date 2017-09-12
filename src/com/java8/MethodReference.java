package com.java8;
/*
 * Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. 
 * Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.
 * 
 * Type 																	=>	Example 							=>	Syntax
1. Reference to a static method													ContainingClass::staticMethodName		Class::staticMethodName
2. Reference to a constructor													ClassName::new							ClassName::new
3. Reference to an instance method of an arbitrary object of a particular type	ContainingType::methodName				Class::instanceMethodName
4. Reference to an instance method of a particular object						containingObject::instanceMethodName	object::instanceMethodName
 */
interface Messageable{
	public void say();
	//public void tell();//declare more than one method: compile error:The target type of this expression must be a functional interface
}
class Mref{
	public Mref(){
		System.out.println("constructor->Mref()");
	}
	public void saySomething(){
		System.out.println("Mref->saySomething()...");
	}
}
public class MethodReference {
	
	public static void main(String[] args) {
		// Reference to a Constructor
		Messageable msg=Mref::new;
		msg.say();
	}

}
