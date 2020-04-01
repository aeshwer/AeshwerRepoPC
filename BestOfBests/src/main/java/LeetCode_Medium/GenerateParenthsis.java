package LeetCode_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthsis {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new LinkedList<String>();
		generateParenthesisUtil("", res, 0, 0, n);
		return res;
	}

	private static void generateParenthesisUtil(String curr, List<String> res, int countS1, int countS2, int n) {
		if (curr.length() == 2 * n) {
			res.add(curr);
			return;
		} else {
			if (countS1 < n) {
				generateParenthesisUtil(curr + "(", res, countS1 + 1, countS2, n);
			}
			if (countS2 < countS1) {
				generateParenthesisUtil(curr + ")", res, countS1, countS2 + 1, n);
			}
		}
	}

	public static void main(String[] args) {
		List<String> generateParenthesis = generateParenthesis(3);
		generateParenthesis.forEach(val -> {
			System.out.println(val);
		});
	}
}
