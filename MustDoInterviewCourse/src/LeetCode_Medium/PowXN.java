package LeetCode_Medium;

//https://leetcode.com/problems/powx-n/
//https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
public class PowXN {
	public static double myPow(double x, int n) {

		if (n == 0)
			return 1;
		if (n < 0) {
			x = 1 / x;
			if (n == Integer.MIN_VALUE) {
				n = -(n + 1);
				x = x * x;
			} else {
				n = -n;
			}

		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);

	}

	public static void main(String[] args) {
		System.out.println(myPow(2,Integer.MIN_VALUE));
	}
}
