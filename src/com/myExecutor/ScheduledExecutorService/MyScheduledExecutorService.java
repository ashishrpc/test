package com.myExecutor.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MyScheduledExecutorService {
    
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Beeper calling....");
        new BeeperControl().beepForAnHour();
        System.out.println("Beep called....");
    }

}
class BeeperControl {
    private final ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
    public void beepForAnHour(){
        final Runnable beeper=new Runnable(){
            public void run(){
                System.out.println("Beep");
            }
        };
        final ScheduledFuture<?> beeperHandle=scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable(){ //great in a executor two task assigned first for beep(beeper) next their future used for stop beeper, here we can see a future can be manage(take care of a thread by future)
            public void run(){
                beeperHandle.cancel(true);//future used for cancel above thread of beeper using another thread
                System.out.println("Stop");
            }
        }, 60*1, TimeUnit.SECONDS);
        //scheduler.shutdown();//if shut down then no beep will come bcz after shutdown no new thread will execute and your beeper execute after 10 sec so this is new thread. 
    }
}
