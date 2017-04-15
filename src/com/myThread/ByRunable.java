package com.myThread;

public class ByRunable implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByRunable obj = new ByRunable();
		Thread th=new Thread(obj);
		th.start();
	}
	public void run(){
		System.out.println("run() in runnable....");
	}
}
