// Note ::  https://crunchify.com/hashmap-vs-concurrenthashmap-vs-synchronizedmap-how-a-hashmap-can-be-synchronized-in-java/
package com.udemyCollectionConcurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizeMapLearn {
	// Only one thread can modify or access the map at a time.
	// All operations (put, get, remove, etc.) are synchronized using intrinsic
	// locks (synchronized keyword) on the entire map.

	// Issues: Full Map Locking: Even for read operations, the entire map is locked,
	// leading to performance bottlenecks.
	// Iteration is Not Thread-Safe:
	public static void main(String[] args) throws InterruptedException {
		Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
		startNewThread(syncMap, "MapHelper1", "one", 1);
		startNewThread(syncMap, "MapHelper2", "two", 2);
		startNewThread(syncMap, "MapHelper3", "three", 3);
		startNewThread(syncMap, "MapHelper4", "four", 4);

		Thread.sleep(2000);
		for (Map.Entry<String, Integer> map : syncMap.entrySet()) {
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
