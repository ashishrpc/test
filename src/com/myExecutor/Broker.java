package com.myExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Broker {
    private ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(100);
    public Boolean continueProducing=Boolean.TRUE;
     
    public void put(Integer data) throws InterruptedException {
        queue.put(data);
    }
    public Integer get() throws InterruptedException {
        return queue.poll(1, TimeUnit.SECONDS);
    } 
}
