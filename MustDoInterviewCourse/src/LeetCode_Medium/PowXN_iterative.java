package LeetCode_Medium;

//https://leetcode.com/problems/powx-n/
//https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
public class PowXN_iterative {
	public static double myPow(double x, int n) {
		double ans = 1;
		long absN = Math.abs((long) n);
		while (absN > 0) {
			if ((absN & 1) == 1)
				ans *= x;
			absN >>= 1;
			x *= x;
		}
		return n < 0 ? 1 / ans : ans;
	}

	public static void main(String[] args) {
		System.out.println(myPow(2, Integer.MIN_VALUE));
	}
}
