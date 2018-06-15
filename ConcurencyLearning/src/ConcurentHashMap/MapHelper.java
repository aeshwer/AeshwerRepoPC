package ConcurentHashMap;

import java.util.Map;

public class MapHelper implements Runnable {
	Map<String, Integer> map;

	public MapHelper(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapHelper1").start();
	}

	public void run() {
		map.put("One", 1);
		try {
			System.out.println("MapHelper1 sleeping");
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}