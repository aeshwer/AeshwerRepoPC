package com.udemyCollectionConcurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Exchanger;

class FirstThread implements Runnable {
	private int counter;
	private Exchanger<Integer> exchanger;

	public FirstThread(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while (true) {
			counter++;
			log("🔼 FirstThread incremented counter to " + counter);

			try {
				log("⏳ Waiting to exchange...");
				counter = exchanger.exchange(counter);
				log("✅ Exchanged! New counter: " + counter);

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void log(String message) {
		System.out.println(getTimestamp() + " [FirstThread] " + message);
	}

	private String getTimestamp() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
}

class SecondThread implements Runnable {
	private int counter;
	private Exchanger<Integer> exchanger;

	public SecondThread(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while (true) {
			counter--;
			log("🔽 SecondThread decremented counter to " + counter);

			try {
				log("⏳ Waiting to exchange...");
				counter = exchanger.exchange(counter);
				log("✅ Exchanged! New counter: " + counter);

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void log(String message) {
		System.out.println(getTimestamp() + " [SecondThread] " + message);
	}

	private String getTimestamp() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
}

public class ExchangerLearn {
	public static void main(String[] args) {
		Exchanger<Integer> exchanger = new Exchanger<>();

		FirstThread firstWorker = new FirstThread(exchanger);
		SecondThread secondWorker = new SecondThread(exchanger);

		new Thread(firstWorker).start();
		new Thread(secondWorker).start();
	}
}
