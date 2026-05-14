package Aug7;

import java.util.TreeMap;
import java.util.TreeSet;

public class test {

	public boolean isNStraightHand(int[] hand, int groupSize) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		
		for (Integer h : hand) {
			map.put(h, map.getOrDefault(h, 0) + 1);
		}
		int size = groupSize;

		while (!map.isEmpty()) {
			int num = map.firstKey();
			while (size > 0 && map.containsKey(num)) {
				int val = map.get(num);
				if (val == 1) {
					map.remove(num);
				} else {
					map.put(num, val - 1);
				}
				num = num + 1;
				size--;
			}

			if (size > 0) {
				return false;
			}
			size = groupSize;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		int[] a = new int[] { 1, 2, 3 };
		test obj = new test();
		obj.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3);
	}

}
