package Company_Solution;

public class jobshop1 {

	public static int solution(int[] A) {
		int maxSoFar = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 3 == 0) {
				maxSoFar = Math.max(maxSoFar, A[i]);
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = { -6, -91, 1011, -100, 84, -22, 0, -10000, -9999,9999 };
		System.out.println(solution(arr));
	}

}
