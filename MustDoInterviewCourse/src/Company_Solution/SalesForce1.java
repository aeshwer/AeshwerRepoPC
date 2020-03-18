package Company_Solution;

import java.util.Arrays;

public class SalesForce1 {

	static void repeating(String str) {

		char[] s = str.toCharArray();
		int length = str.length();
		int count[] = new int[s.length];
		count[0] = 0;

		int i = 0;
		for (int j = 1; j < length; j++) {
			if (s[j] == s[i]) {
				i++;
				count[j] = i;
			} else {
				if (i != 0) {
					i = count[i - 1];
					j--;
				} else
					count[j] = 0;
			}

		}

		int last = count[count.length - 1];
		if (last > 0 && length % (length - last) == 0) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}

	}

	public static void main(String[] args) {
		repeating("abcdabca");
	}
}
