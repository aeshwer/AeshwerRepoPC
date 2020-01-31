package BackTrackingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

	public static void main(String[] args) {
		Subset2 obj = new Subset2();
		int[] arr = { 1, 2, 2 }; // Can Have duplicates
		List<List<Integer>> result = obj.subsetsWithDup(arr);
		result.forEach(v -> System.out.println(v));
	}


	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int [] nums, int start){
	    resultList.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	        tempList.add(nums[i]);
	        backtrack(resultList, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
}
