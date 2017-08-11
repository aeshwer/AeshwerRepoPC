package com.udemyConcurreny;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * Simulate download data from the web and create a singleton pattern using enums
 */


// thread safe singleton enum implementation
enum Downloader
	{
		 INSTANCE;
		 private Semaphore semaphore = new Semaphore(3, true);
		 
		 public void downloadData()
		 { 
			 try {
				semaphore.acquire();
				download();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 finally{
				 semaphore.release();}
		 }
		 
		 private void download()
		 {
			 System.out.println("Download data from web...");
			 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	}
public class SemaphoreLearn {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0;i<10;i++){
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Downloader.INSTANCE.downloadData();   // singleton pattern
				}
			});
		}
			
			
	}
}
