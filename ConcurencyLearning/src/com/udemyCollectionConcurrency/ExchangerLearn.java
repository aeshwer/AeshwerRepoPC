package com.udemyCollectionConcurrency;

import java.util.concurrent.Exchanger;


class firstThread implements Runnable{

	private int counter;
	private Exchanger<Integer> exchanger;
	
	public firstThread(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while(true){
			counter = counter +1;
			System.out.println("First thread increment the counter: "+ counter);
			try {
				counter = exchanger.exchange(counter);   // send and get here
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	 
		}
	}
	
}

class secondThread implements Runnable{

	private int counter;
	private Exchanger<Integer> exchanger;
	
	public secondThread(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while(true){
			counter = counter -1;
			System.out.println("Second thread decrement the counter: "+ counter);
			try {
				counter = exchanger.exchange(counter);   // send and get here
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}

public class ExchangerLearn {

	public static void main(String[] args) {
		Exchanger<Integer> exchanger = new Exchanger<Integer>();
		
		firstThread firstWorker = new firstThread(exchanger);
		secondThread secondWorker = new secondThread(exchanger);
		
		new Thread(firstWorker).start();
		new Thread(secondWorker).start();
 	}
}
