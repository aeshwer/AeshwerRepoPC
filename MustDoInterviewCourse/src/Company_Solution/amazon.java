package Company_Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class amazon {

	/*
	 * Complete the function below.
	 */
	static String findQualifiedNumbers(int[] numberArray) {

		int result[] = new int[numberArray.length];
		result[0] = -1;
		int resIndex = 0;
		for (int i = 0; i < numberArray.length; i++) {

			int temp = numberArray[i];
			int counter[] = new int[3];
			int rem = 0;
			while (temp > 0) {
				rem = temp % 10;
				temp = temp / 10;
				if (rem == 1)
					counter[0]++;
				if (rem == 2)
					counter[1]++;
				if (rem == 3)
					counter[2]++;

				if (counter[0] >= 1 && counter[1] >= 1 && counter[2] >= 1) {
					result[resIndex] = numberArray[i];
					resIndex++;
					break;
				}
			}
		}
		String str = "";
		if (result[0] == -1) {
			return "-1";
		} else {
			Arrays.sort(result);
			for (int j = result.length - resIndex; j < result.length-1 ; j++) {
				str = str + ((Integer) result[j]).toString() + ",";
			}
		}

		//System.out.println(str + ((Integer) result[result.length-1]).toString());
		return str + ((Integer) result[result.length-1]).toString();

	}

	public static void main(String[] args) throws IOException {
		int numberArray[] = {1456, 345671, 43218, 123};
		findQualifiedNumbers(numberArray);
	}
}
