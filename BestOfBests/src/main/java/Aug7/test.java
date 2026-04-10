package Aug7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test {
	public int findUnsortedSubarray(int[] nums) {
		int startIndex = -1;
		int endIndex = -1;
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < nums.length; i++) {
			if (stk.isEmpty() || nums[stk.peek()] < nums[i]) {
				stk.push(i);
				continue;
			}
			int maxNumIndex = stk.peek();
			while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
				stk.pop();
			}
		
			if (startIndex == -1) {
				startIndex = stk.isEmpty() ? 0 : stk.peek()+1;
			}
			stk.push(maxNumIndex);
			endIndex = Math.max(endIndex, i);

		}

		System.out.println(startIndex + "  " + endIndex);
		return startIndex == -1 ? 0 : (endIndex - startIndex + 1);
	}

	public static void main(String[] args) {
		test obj = new test();
		obj.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 });

	}

}
