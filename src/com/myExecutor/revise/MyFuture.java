package com.myExecutor.revise;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		ExecutorService executor=Executors.newFixedThreadPool(9);//newFixedThreadPool(2) : if add more than 2 thread like 3 than first two thread complete and third thread will execute
		executor.execute(new myRunable("1st")); 
		Future future0 = executor.submit(new myRunable("0rd"));//in runable case null return from future.get()
		
		Future<String> future = executor.submit(new myCallable("3rd"));
		Future<String> future2 = executor.submit(new myCallable("4rd"));
		//future2.cancel(false);
		System.out.println("done....submit");
		System.out.println(future.get());//pool-1-thread-3 : Sum value :45
		
		System.out.println(future2.get());//pool-1-thread-4 : Sum value :45
		System.out.println(future0.get());//null
		
		System.out.println("done....");
		executor.shutdown();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}

class myRunable implements Runnable{
	private String name;
	public myRunable(String name){
		this.name=name;
	}
	public void run(){
		
		for(int i=0;i<10;i++){
			System.out.println("myRunable..."+this.name);
			try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
		}
	}
}

class myCallable implements Callable<String>{
	private String name;
	public myCallable(String name){
		this.name=name;
	}
	public String call(){
		int sum=0;
		for(int i=0;i<10;i++){
			System.out.println("myCallable..."+this.name);
			sum=sum+i;
			try{Thread.sleep(2000);}catch(Exception e){e.printStackTrace();}
		}
		return Thread.currentThread().getName()+" : Sum value :"+sum;
	}
}
