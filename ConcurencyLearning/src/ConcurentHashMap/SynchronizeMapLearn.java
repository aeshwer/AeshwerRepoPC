// Note ::  https://crunchify.com/hashmap-vs-concurrenthashmap-vs-synchronizedmap-how-a-hashmap-can-be-synchronized-in-java/
package ConcurentHashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// why is concurrent map better.... it is better in case the number of read operations are fairly more in number

public class SynchronizeMapLearn {

	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		Map<String, Integer> syncMap = Collections.synchronizedMap(hashMap);
		MapHelper1 mapHelper1 = new MapHelper1(syncMap);
		MapHelper2 mapHelper2 = new MapHelper2(syncMap);
		MapHelper3 mapHelper3 = new MapHelper3(syncMap);
		MapHelper4 mapHelper4 = new MapHelper4(syncMap);

		for (Map.Entry<String, Integer> map : syncMap.entrySet()) {
			System.out.println(map.getKey() + "=" + map.getValue());
		}
	}
}
