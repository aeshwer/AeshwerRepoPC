package Company_Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExperiTes2 {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 6, 3, 3, 5 };
		solution(arr);
	}

	public static int solution(int[] A) {
		int count = 0;

		// have a list of number position
		Map<Integer, ArrayList<Integer>> lookup = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (!lookup.containsKey(A[i])) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(i);
				lookup.put(A[i], temp);
			} else {
				ArrayList<Integer> temp = lookup.get(A[i]);
				temp.add(i);
			}
		}

		for (Map.Entry<Integer, ArrayList<Integer>> m : lookup.entrySet()) {
			int listSize = m.getValue().size();
			count = count + listSize * (listSize - 1) / 2;

		}

		if (count >= 1000000000) {
			return 1000000000;
		}
		return count;
	}

}
