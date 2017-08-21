package com.pool;

import java.util.concurrent.Semaphore;

class Pool {
    private static final int MAX_AVAILABLE = 100;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
/*
 * You can also use a bounded semaphore to limit the number of threads allowed into a section of code. For instance, in the example above, what would happen if you set the limit of the BoundedSemaphore to 5? 5 threads would be allowed to enter the critical section at a time. You would have to make sure though, that the thread operations do not conflict for these 5 threads, or you application will fail.

	The relase() method is called from inside a finally-block to make sure it is called even if an exception is thrown from the critical section.
 */
		
    public Object getItem() throws InterruptedException {
      available.acquire();
      return getNextAvailableItem();
    }

    public void putItem(Object x) {
      if (markAsUnused(x))
        available.release();
    }

    // Not a particularly efficient data structure; just for demo

    protected Object[] items = new Object[MAX_AVAILABLE];//... whatever kinds of items being managed
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
      for (int i = 0; i < MAX_AVAILABLE; ++i) {
        if (!used[i]) {
           used[i] = true;
           return items[i];
        }
      }
      return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
      for (int i = 0; i < MAX_AVAILABLE; ++i) {
        if (item == items[i]) {
           if (used[i]) {
             used[i] = false;
             return true;
           } else
             return false;
        }
      }
      return false;
    }

  }
