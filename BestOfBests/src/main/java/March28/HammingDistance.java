package March28;

public class HammingDistance {

	public static int hammingDistance(int x, int y) {
		int n = x ^ y;
		int count = 0;
		
		// now count number of 1's bit
		while (n > 0) {
			count = count + (n & 1);
			n >>= 1;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));// 2
	}
}
