package SortingQuestions;

public class SquareRootOfANumber {

	public static int mySqrt(int x) { // Base Cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search for floor(sqrt(x))
		int left = 1, right = x, ans = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// If x is a perfect square
			if (mid * mid == x)
				return mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			if (mid * mid < x) {
				left = mid + 1;
				ans = mid;
			} else // If mid*mid is greater than x
				right = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) {

		System.out.println(mySqrt(5));
	}
}
