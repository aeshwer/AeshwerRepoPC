//Note : http://javainuse.com/java/javaConcurrentHashMap

package com.udemyCollectionConcurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapLearn {
	//Uses segmented locking - instead of full map lock
	//Reads are non-blocking → multiple threads can read without locking.
	//Writes lock only small parts
	public static void main(String[] args) throws InterruptedException {
		Map<String, Integer> conMap = new ConcurrentHashMap<>();
		startNewThread(conMap, "MapHelper1", "one", 1);
		startNewThread(conMap, "MapHelper2", "two", 2);
		startNewThread(conMap, "MapHelper3", "three", 3);
		startNewThread(conMap, "MapHelper4", "four", 4);

		Thread.sleep(2000);
		for (Map.Entry<String, Integer> map : conMap.entrySet()) {
			System.out.println(map.getKey() + "=" + map.getValue());
		}
	}

	private static void startNewThread(Map<String, Integer> conMap, String name, String key, int val) {
		new Thread(() -> {
			conMap.put(key, val);
			try {
				System.out.println(name + " sleeping");
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			}
		}).start();
	}
}
