package com.dataStructure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * priority queue based on a priority heap.Following are the important points about PriorityQueue:

> VVI: The head of the priority queue is the least(like 0, 5 , 7, 8) element based on the natural ordering or comparator based ordering,
> The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used.
> A priority queue does not permit null elements.
> A priority queue relying on natural ordering also does not permit insertion of non-comparable objects.
> default initial capacity (11) and use default natural ordering if comparator not provided
> Priority Queue size is unbounded but we can specify the initial capacity at the time of it’s creation. When we add elements to the priority queue, it’s capacity grows automatically.
> PriorityQueue doesn’t allow null
> PriorityQueue is not thread safe, so java provides PriorityBlockingQueue class for multithreading
> O(log(n)) time for enqueing and dequeing method
> Methods:
boolean add(E element): This method inserts the specified element into this priority queue.
public remove(): This method removes a single instance of the specified element from this queue, if it is present
public poll(): This method retrieves and removes the head of this queue, or returns null if this queue is empty.
public peek(): This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.

 */
public class MyPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue=new PriorityQueue<String>(3);
		queue.add("ZBC1");
		queue.add("ABC2");
		queue.add("HBC3");
		queue.add("ABC4");
		queue.add("CBC5");
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println("Queue"+queue);
		System.out.println("-----------------Comparator-------------");
		Queue<Student> queueCom=new PriorityQueue<Student>(3,stComparator);
		queueCom.add(new Student(405,"Stu 405"));
		queueCom.add(new Student(505,"Stu 505"));
		queueCom.add(new Student(105,"Stu 105"));
		queueCom.add(new Student(102,"Stu 102"));
		System.out.println("Queue"+queueCom);
	}

	public static Comparator<Student> stComparator=new Comparator<Student>() {
		@Override
		public int compare(Student st1, Student st2){
			return st1.getId()-st2.getId();
		}
	};  
	
}

class Student {
	int id;
	String name;
	
	public Student(){
		
	}
	public Student(int id,String name){
		this.id=id;
		this.name=name;
	}
	@Override
	public String toString(){
		return this.id+" <=> "+this.name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}