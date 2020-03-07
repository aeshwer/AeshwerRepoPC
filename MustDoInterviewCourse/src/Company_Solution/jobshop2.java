package Company_Solution;

import java.util.HashMap;
import java.util.Map;

public class jobshop2 {

	public static String solution(String[] A) {
		StringBuilder result = new StringBuilder();
		Map<Integer, Integer> lookup = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			switch (A[i].charAt(0)) {
			case 'i':
				String[] split = A[i].split(":");
				lookup.put(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
				break;
			case 'j':
				int valueToLook = Integer.parseInt(A[i].split(":")[1]);
				if (lookup.containsKey(valueToLook)) {
					result.append(lookup.get(valueToLook)).append(" ");
				} else {
					result.append(-1).append(" ");
				}
				break;
			case 'k':
				result.append(lookup.size()).append(" ");
				break;
			case 'l':
				int valueToRemove = Integer.parseInt(A[i].split(":")[1]);
				lookup.remove(valueToRemove);
				break;
			}

		}
		return result.toString();

	}

	public static void main(String[] args) {
		String[] str = { "i:1:2", "i:66:3", "j:66", "l:1", "k" };
		System.out.println(solution(str));
	}

}
