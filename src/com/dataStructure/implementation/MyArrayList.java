package com.dataStructure.implementation;

import java.util.Arrays;

public class MyArrayList<E> {

	private int size;
	private int index;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        this.size=DEFAULT_CAPACITY;
        
    }
	
    public MyArrayList(int capacity) {
        elements = new Object[capacity];
        this.size=capacity;
    }
    
    public void add(E element){
    	if(this.index==this.size-1){
    		//we need to increase the size of []
			increaseSizeAndReallocate();
    	}
    	elements[this.index]=element;
    	this.index++;
    }
    
    public void increaseSizeAndReallocate(){
    	this.size=this.size*2;
    	System.out.println("newCapacity: "+this.size);
    	elements=Arrays.copyOf(elements, this.size);
    }
    
    public E get(int i){
    	if(i>this.index-1){
			throw new IndexOutOfBoundsException("ArrayIndexOutOfBound");
		}
		if(i<0){
			throw new IndexOutOfBoundsException("Negative Value");
		}
        return (E) elements[i]; 
    }
    
    public void remove(int i) throws IndexOutOfBoundsException{
		if(i>this.index-1){
			throw new IndexOutOfBoundsException("ArrayIndexOutOfBound");
		}
		if(i<0){
			throw new IndexOutOfBoundsException("Negative Value");
		}
		System.out.println("Object getting removed: "+this.elements[i]);
		for(int x=i; x<this.elements.length-1;x++){
			elements[x]=elements[x+1];
		}
		this.index--;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList<Integer> list = new MyArrayList<Integer>(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        //list.remove(4);
        System.out.println(4 == list.get(4));
        System.out.println(2 == list.get(1));
        System.out.println(3 == list.get(2));

        list.get(6);
	}

}
