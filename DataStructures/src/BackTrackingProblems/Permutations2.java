package BackTrackingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/
public class Permutations2 {

	public static void main(String[] args) {
		Permutations2 obj = new Permutations2();
		int[] arr = { 1, 1, 2 ,2}; // input have duplicates
		List<List<Integer>> result = obj.permuteUnique(arr);
		result.forEach(v -> System.out.println(v));
	}

	public List<List<Integer>> permuteUnique(int[] arr) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(arr);
	    backtrack(list, new ArrayList<>(), arr, new boolean[arr.length]);
	    return list;
	}

	private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int [] nums, boolean [] used){
	    if(tempList.size() == nums.length){
	        resultList.add(new ArrayList<>(tempList));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrack(resultList, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}

}
