package Company_Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Amazon2 {

	// Complete the getCountOfPossibleTeams function below.
	static int getCountOfPossibleTeams(List<Integer> coders) {

		int one[] = new int[coders.size()];
		Arrays.fill(one, 1);
		int two[] = new int[coders.size()];
		int three[] = new int[coders.size()];
		Integer T[] = coders.stream().toArray(Integer[]::new);

		for (int i = 1; i < T.length; i++) {
			for (int j = 0; j < i; j++) {
				if (T[j] < T[i]) {
					two[i] = two[i] + 1;
					if (two[j]!= 0) {
						three[i] = three[i]+1;
					}
				}

			}
		}
		int count = 0;
		for (int i = 0; i < three.length; i++) {
			if (three[i] >0) {
				count=count+three[i];
			}
		}

		Arrays.fill(two, 0);
		Arrays.fill(three, 0);
		for (int i = 1; i < T.length; i++) {
			for (int j = 0; j < i; j++) {
				if (T[j] > T[i]) {
					two[i] = two[i] + 1;
					if (two[j]!= 0) {
						three[i] = three[i]+1;
					}
				}

			}
		}
		
		for (int i = 0; i < three.length; i++) {
			if (three[i] > 0) {
				count=count+three[i];
			}
		}
		System.out.println(count);
		return count;
	}

	public static void main(String[] args) {
		List<Integer> coders = new ArrayList<>();
		coders.addAll(Arrays.asList(5, 2, 3, 4,1));
		getCountOfPossibleTeams(coders);
	}
}
