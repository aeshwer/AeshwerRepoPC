package Md_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PermutationOfNonDistinctNumbers {

	public List<List<Integer>> permuteUnique(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		List<List<Integer>> resultList = new ArrayList<>();
		int[] numbers = new int[map.size()];
		int[] freq = new int[map.size()];
		int[] result = new int[nums.length];
		int index = 0;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			numbers[index] = m.getKey();
			freq[index] = m.getValue();
			index++;
		}

		permuteUtil(numbers, resultList, result, freq, 0);
		return resultList;
	}

	public void permuteUtil(int[] numbers, List<List<Integer>> resultList, int[] res, int[] freq, int depth) {

		if (res.length == depth) {
			resultList.add(Arrays.stream(res).boxed().collect(Collectors.toList()));
			return;
		} else {
			for (int i = 0; i < numbers.length; i++) {
				if (freq[i] > 0) {
					res[depth] = numbers[i];
					freq[i]--;
					permuteUtil(numbers, resultList, res, freq, depth + 1);
					freq[i]++;
				}
			}

		}

	}
	
	public static void main(String[] args) {
		PermutationOfNonDistinctNumbers obj = new PermutationOfNonDistinctNumbers();
		List<List<Integer>> permuteUnique = obj.permuteUnique(new int[] {1,1,2});
		permuteUnique.forEach( l -> {
			l.forEach( out -> {
				System.out.print( out+" ");
			});
			System.out.println();
		});
	}
}
