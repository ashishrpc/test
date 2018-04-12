package com.dataStructure.implementation;

import java.util.NoSuchElementException;

public class MyStack<T> {
	private T[] stackArr;
	private int maxSize;
	private int top;
	private int len;
	
	 /*  Constructor for arrayStack */
	public MyStack(){}
    public MyStack(int maxSize)
    {
        this.maxSize = maxSize;
        len = 0;
        stackArr = (T[]) new Object[maxSize];//new T[maxSize];
        top = -1;
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == -1;
    }
    /*  Function to check if stack is full */
    public boolean isFull()
    {
        return top == maxSize -1 ;        
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return len ;
    }
    /*  Function to check the top element of the stack */
    public T peek()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return stackArr[top];
    }
    /*  Function to add an element to the stack */
    public void push(T data)
    {
        if(top + 1 >= maxSize)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < maxSize )
        	stackArr[++top] = data;
        len++ ;
    }
    /*  Function to delete an element from the stack */
    public T pop()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        len-- ;
        return stackArr[top--]; 
    }   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<String> myStack=new MyStack<String>(2);
		myStack.push("Ashish1");
		myStack.push("Ashish2");
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		//System.out.println(myStack.pop());
	}

}
