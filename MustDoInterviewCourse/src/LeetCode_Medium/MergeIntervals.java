package LeetCode_Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

	public static int[][] merge(int[][] intervals) {
		if (intervals == null)
			return null;
		if (intervals.length <= 1)
			return intervals;

		// sort Array with respect to start index
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		System.out.println("After Sort Input  " + Arrays.deepToString(intervals));
		
		int upperLimit = intervals[0][1];
		int resIndex = 0;

		for (int i = 1; i < intervals.length; i++) {
			if ((upperLimit >= intervals[i][0] && upperLimit <= intervals[i][1]) || (upperLimit >= intervals[i][1])) {
				if (upperLimit <= intervals[i][1]) {
					intervals[resIndex][1] = intervals[i][1];
					upperLimit = intervals[i][1];
				}
				continue;
			}
			resIndex++;
			intervals[resIndex][0] = intervals[i][0];
			intervals[resIndex][1] = intervals[i][1];
			upperLimit = intervals[i][1];

		}
		System.out.println(resIndex);

		int res[][] = new int[resIndex + 1][2];
		for (int i = 0; i <= resIndex; i++) {
			res[i][0] = intervals[i][0];
			res[i][1] = intervals[i][1];
		}

		return res;
	}

	public static void main(String[] args) {
		 int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		//int[][] intervals = { { 1, 4 }, { 0, 2 }, { 3, 5 } };
		System.out.println("Input " + Arrays.deepToString(intervals));
		System.out.println("Output " + Arrays.deepToString(merge(intervals)));
	}
}
