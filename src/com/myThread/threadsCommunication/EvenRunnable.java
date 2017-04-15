package com.myThread.threadsCommunication;

public class EvenRunnable implements Runnable { 
	private int number = 2;
	private Object shared = null;
	public EvenRunnable(Object object) {
		shared = object;
	}
	public void run() {
		while (number < 50) {
			synchronized (shared) {
				System.out.println("Even number =  " + number);
				number = number + 2;
				try {
					Thread.sleep(500); //only to view sequence of execution
					shared.notify();
					shared.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
