package com.myThread.myExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Broker {
	/*
	 A bounded blocking queue backed by an array. This queue orders elements FIFO (first-in-first-out). The head of the queue 
	 is that element that has been on the queue the longest time. The tail of the queue is that element that has been on the 
	 queue the shortest time. New elements are inserted at the tail of the queue, and the queue retrieval operations obtain 
	 elements at the head of the queue. 

	This is a classic "bounded buffer", in which a fixed-sized array holds elements inserted by producers and extracted by 
	consumers. Once created, the capacity cannot be increased. Attempts to put an element into a full queue will result in 
	the operation blocking; attempts to take an element from an empty queue will similarly block. 
	
	This class supports an optional fairness policy for ordering waiting producer and consumer threads. By default, this 
	ordering is not guaranteed. However, a queue constructed with fairness set to true grants threads access in FIFO order. 
	Fairness generally decreases throughput but reduces variability and avoids starvation. 
	
	This class and its iterator implement all of the optional methods of the Collection and Iterator interfaces. 
	
	This class is a member of the Java Collections Framework.
	 */
    private ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(100);//Creates an ArrayBlockingQueue with the given (fixed) capacity and default access policy.
    public Boolean continueProducing=Boolean.TRUE;
     
    /*
     * Inserts the specified element at the tail of this queue, waiting for space to become available if the queue is full.
     */
    public void put(Integer data) throws InterruptedException {
        queue.put(data);
    }
    /*
     * Retrieves and removes the head of this queue, waiting up to the specified wait time if necessary for an element to become available.
     * Parameters:
			timeout how long to wait before giving up, in units of unit
			unit a TimeUnit determining how to interpret the timeout parameter
		Returns:
			the head of this queue, or null if the specified waiting time elapses before an element is available
		Throws:
			InterruptedException - if interrupted while waiting
     */
    public Integer get() throws InterruptedException {
        return queue.poll(1, TimeUnit.SECONDS);
    } 
}
