package Md_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationOfDistinctNUmber {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		int[] result = new int[nums.length];
		int[] freq = new int[nums.length];
		Arrays.fill(freq, 1);
		permuteUtil(nums, resultList, result, freq, 0);

		return resultList;
	}

	public void permuteUtil(int[] nums, List<List<Integer>> resultList, int[] res, int[] freq, int depth) {

		if (nums.length == depth) {
			resultList.add( Arrays.stream(res).boxed().collect(Collectors.toList()));
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (freq[i] > 0) {
					res[depth] = nums[i];
					freq[i]--;
					permuteUtil(nums, resultList, res, freq, depth + 1);
					freq[i]++;
				}
			}

		}

	}

	public static void main(String[] args) {

		PermutationOfDistinctNUmber obj = new PermutationOfDistinctNUmber();
		List<List<Integer>> permuteUnique = obj.permute(new int[] {1,2,3});
		permuteUnique.forEach( l -> {
			l.forEach( out -> {
				System.out.print( out+" ");
			});
			System.out.println();
		});
	
	}
}
