package March28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOf2Array {

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				res.add(nums2[i]);
				set.remove(nums2[i]);
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {

	}
}
