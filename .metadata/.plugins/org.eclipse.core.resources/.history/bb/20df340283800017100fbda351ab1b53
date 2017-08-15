package com.udemyConcurreny;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceLearn {
    public static void main(String[] args) {
       // ExecutorService executerService = Executors.newFixedThreadPool(4);
      // ExecutorService executerService = Executors.newSingleThreadExecutor();
    	ExecutorService executerService = Executors.newCachedThreadPool(  );

        for (int i = 0; i < 10; i++) {
            executerService.submit(new worker2());
        }
    }
}


class worker2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
