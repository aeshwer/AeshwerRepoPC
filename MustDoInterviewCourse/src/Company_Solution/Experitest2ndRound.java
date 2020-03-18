package Company_Solution;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * input - [a, b, c], [d, e], [f, g, h]
 * 
 * output - all combinations of "1 element form each list"
 * --> [a, d, f], [a, d, g], [a, d, h], [b, d, f], ....
 * 
 */
public class Experitest2ndRound {
	public static void main(String[] args) {
		List<List<Character>> input = new ArrayList<>();
		List<Character> t1 = new ArrayList<>();
		List<Character> t2 = new ArrayList<>();
		List<Character> t3 = new ArrayList<>();
		t1.add('a');
		t1.add('b');
		t1.add('c');

		t2.add('d');
		t2.add('e');

		t3.add('f');
		t3.add('g');
		t3.add('h');
		input.add(t1);
		input.add(t2);
		input.add(t3);
		allCombinations(input);
	}

	static void allCombinations(List<List<Character>> input) {
		List<Character> res = new ArrayList<>();
		int resSize = input.size();
		allCombinationsUtil(input, res, resSize, 0);
	}

	static void allCombinationsUtil(List<List<Character>> input, List<Character> res, int resSize, int outerIndex) {

		if (res.size() == resSize) {
			System.out.println(res.toString());
		}

		else {
			//for (int i = outerIndex; i < resSize; i++) {
				List<Character> innerList = input.get(outerIndex);
				for (int j = 0; j < innerList.size(); j++) {
					res.add(innerList.get(j));
					allCombinationsUtil(input, res, resSize, outerIndex + 1);
					res.remove(res.size() - 1);
				}
			}
		//}

	}
}
