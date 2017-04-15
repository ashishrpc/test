package com.myThread.threadsCommunication;

public class OddRunnable implements Runnable {

	int oddNumber = 1;
    private Object shared = null;
    public OddRunnable(Object object) {
        shared = object;
    }
    public void run() {
        while (oddNumber < 50) {
            synchronized (shared) {
                System.out.println("Odd number = " + oddNumber);
                String str="abc";
                oddNumber = oddNumber + 2;
                try {
                	//str.wait(); //throw IllegalMonitorStateException
                    Thread.sleep(500); // only to view the sequence of execution
                    shared.notify();
                    shared.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();  
                }
            }
        }
    }

}
