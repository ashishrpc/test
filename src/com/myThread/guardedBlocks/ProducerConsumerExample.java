package com.myThread.guardedBlocks;

/**
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
 * 
 * @author Ashish ranjan
 *
 */
public class ProducerConsumerExample {
	public synchronized void fun(){
		System.out.println("going to wait");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" wait over..");
		notify();
	}
	public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
//		ProducerConsumerExample obj=new ProducerConsumerExample();
//		obj.fun();
//		obj.notifyAll();
    }
}
