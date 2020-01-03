package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PairWithGivenSum {

	public static class FastReader {

		BufferedReader read;
		StringTokenizer token;

		public FastReader() {
			read = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		private String next() {
			while (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(read.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}
	}

	static void sumPair(int arr1[], int arr2[], int x) {
		Map<Integer, Integer> lookup = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();

		boolean result = false;
		for (int i = 0; i < arr1.length; i++) {
			lookup.put(arr1[i], i);
		}

		for (int i = 0; i < arr2.length; i++) {
			if (lookup.containsKey(x - arr2[i])) {
				result = true;
				List<Integer> temp = new ArrayList<>();
				temp.add(arr2[i]);
				temp.add(x - arr2[i]);
				list.add(temp);
			}

		}
		if (!result) {
			System.out.print(-1);
		} else {
			Collections.sort(list, new Comparator<List<Integer>>() {
				@Override
				public int compare(List<Integer> o1, List<Integer> o2) {
					if (Integer.compare(o1.get(0), o2.get(0)) != 0) {
						return Integer.compare(o1.get(0), o2.get(0));
					} else {
						return Integer.compare(o1.get(1), o2.get(1));
					}
				}
			});

			list.forEach(l -> {
				l.forEach(value -> {
					System.out.print(value +" ");
				});
				System.out.print(", ");
			});

		}

	}

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int cases = reader.nextInt();

		while (--cases >= 0) {
			int m = reader.nextInt();
			int n = reader.nextInt();
			int x = reader.nextInt();

			int arr1[] = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr1[i++] = reader.nextInt();
			}

			int arr2[] = new int[m];
			int j = 0;
			while (--m >= 0) {
				arr2[j++] = reader.nextInt();
			}

			sumPair(arr1, arr2, x);
			System.out.println();
		}
	}

}
