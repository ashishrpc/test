package com.myThread;

public class Deadlock {

	/**
	 * @param args
	 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other. 
	 * Here's an example.
	 * 
	 * Alphonse and Gaston are friends, and great believers in courtesy. A strict rule of courtesy is that 
	 * when you bow to a friend, you must remain bowed until your friend has a chance to return the bow. 
	 * Unfortunately, this rule does not account for the possibility that two friends might bow to each other 
	 * at the same time. This example application, Deadlock, models this possibility:
	 */
	
	static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) throws InterruptedException {
            System.out.format("%s: %s"
                + "  has bowed to me!%n", 
                this.name, bower.getName());
            //Thread.sleep(10000);// if same object called this method multiple time then other will wait to take lock and then execute
            bower.bowBack(this);//it will call the synchronized method because lock acquire by same object(this), 
            //so no need to take lock
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Friend alphonse =new Friend("alphonse");
		final Friend gaston = new Friend("gaston");
		new Thread(new Runnable(){
			public void run(){try {
				alphonse.bow(gaston);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
		}).start();
		new Thread(new Runnable() {
            public void run() { try {
            	gaston.bow(alphonse);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
        }).start();
	} 

}
