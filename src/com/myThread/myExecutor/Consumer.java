package com.myThread.myExecutor;

import java.util.Collection;
import java.util.concurrent.Callable;

public class Consumer implements Runnable, Callable {
    private String name;
    private Broker broker;
    public Consumer(String name, Broker broker){
        this.name=name;
        this.broker=broker;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Integer data=broker.get();
            while(broker.continueProducing || data!=null){
                Thread.sleep(100);
                System.out.println("Consumenr "+this.name+" processed data from broker : "+data);
                data=broker.get();
            }
            System.out.println("Consumer "+this.name+" finished his job; terminate");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public Object call() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
}
