//Note : http://javainuse.com/java/javaConcurrentHashMap

package ConcurentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapLearn {

	public static void main(String[] args) {
		Map<String, Integer> conMap = new ConcurrentHashMap<>();
		MapHelper1 mapHelper1 = new MapHelper1(conMap);
		MapHelper2 mapHelper2 = new MapHelper2(conMap);
		MapHelper3 mapHelper3 = new MapHelper3(conMap);
		MapHelper4 mapHelper4 = new MapHelper4(conMap);

		for (Map.Entry<String, Integer> map : conMap.entrySet()) {
			System.out.println(map.getKey() + "=" + map.getValue());
		}
	}
}
