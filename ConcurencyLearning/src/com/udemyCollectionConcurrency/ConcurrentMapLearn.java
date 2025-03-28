package com.udemyCollectionConcurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class workerPut implements Runnable {

	private ConcurrentMap<String, Integer> map;

	public workerPut(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {
			map.put("B", 1);
			map.put("H", 3);
			Thread.sleep(1000);
			map.put("D", 2);
			Thread.sleep(1000);
			map.put("F", 4);
			map.put("E", 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class workerTake implements Runnable {

	private ConcurrentMap<String, Integer> map;

	public workerTake(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(4000);
			System.out.println(map.get("B"));
			Thread.sleep(1000);
			System.out.println(map.get("E"));
			System.out.println(map.get("D"));
			System.out.println(map.get("X"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ConcurrentMapLearn {
	public static void main(String[] args) {
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		workerPut firstWorker = new workerPut(map);
		workerTake secondWorker = new workerTake(map);

		new Thread(firstWorker).start();
		new Thread(secondWorker).start();

	}

}
