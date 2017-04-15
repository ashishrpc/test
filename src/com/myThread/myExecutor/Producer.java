package com.myThread.myExecutor;

public class Producer implements Runnable{
    
    private Broker broker;

    public Producer(Broker broker){
        this.broker=broker;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            for(int i=0;i<10;i++){
                System.out.println("Producer produce : "+i);
                Thread.sleep(100);
                broker.put(i);
            }
            this.broker.continueProducing=Boolean.FALSE;
            System.out.println("Producer Finished its job; terminating");
        }catch(InterruptedException  e){
            System.out.println(e);
        }
    }
    
    
}
