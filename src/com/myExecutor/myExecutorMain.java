package myExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class myExecutorMain {

    /**
     * @param args
     */
	/*
	 The Executor framework helps to decouple a command submission from command execution.

In the java.util.concurrent package there are three interfaces:

Executor — Used to submit a new task.

ExecutorService — A subinterface of Executor that adds methods to manage lifecycle of threads used to run the submitted tasks and methods to produce a Future to get a result from an asynchronous computation.

ScheduledExecutorService — A subinterface of ExecutorService, to execute commands periodically or after a given delay.
 
	 */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Broker broker=new Broker();
            ExecutorService executor=Executors.newFixedThreadPool(4);
            executor.execute(new Consumer("1",broker));/*Executes the given command at some time in the future. The command may execute in a new thread, in a pooled thread, or in the calling thread, at the discretion of the Executor implementation.*/
            executor.execute(new Consumer("2", broker));
            executor.execute(new Consumer("3", broker));
            executor.execute(new Consumer("4", broker));
            
            Future future=executor.submit(new Producer(broker));/*Submits a Runnable task for execution and returns a Future representing that task. The Future's get method will return null upon successful completion.*/
            future.get();
            executor.shutdown();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
