package Company_Solution;

public class jobshop4 {

	public static int solution(int N, int K) {
		if (K == 0)
			return N - 1;
		int result = 0;
		while (N >= 2) {
			if (N % 2 != 0) {
				N--;
				result++;
			} else {
				if (K > 0) {
					N = N / 2;
					result++;
					K--;
				} else {
					result = result + N - 1;
					return result;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(2147483647,100));
	}

}
