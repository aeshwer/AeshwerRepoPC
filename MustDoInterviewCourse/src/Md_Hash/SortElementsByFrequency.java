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

public class SortElementsByFrequency {

	public static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			if (token == null || !token.hasMoreTokens()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();

		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}
	}

	// Implement Comparator Interface to sort the values
	public static class SortComparator implements Comparator<Integer> {

		private Map<Integer, Integer> countMap;

		public SortComparator(Map<Integer, Integer> countMap) {
			this.countMap = countMap;
		}

		@Override
		public int compare(Integer k1, Integer k2) {

			// Compare value by frequency
			int freqCompare = countMap.get(k2).compareTo(countMap.get(k1));

			// Compare value if frequency is equal
			int valueCompare = k1.compareTo(k2);

			// If frequency is equal, then just compare by value, otherwise -
			// compare by the frequency.
			if (freqCompare == 0)
				return valueCompare;
			else
				return freqCompare;
		}
	}

	private static void sortByFrequency(int[] arr) {

		Map<Integer, Integer> countMap = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();

		// Assign elements and their count in the list and map
		for (int current : arr) {
			int count = countMap.getOrDefault(current, 0); // return the count for key , if not found return 0
			countMap.put(current, count + 1);
			outputArray.add(current);
		}

		// Compare the map by value
		SortComparator comp = new SortComparator(countMap);

		// Sort the map using Collections CLass
		Collections.sort(outputArray, comp);

		// Final Output
		for (Integer i : outputArray) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			int n = fastReader.nextInt();
			int arr[] = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr[i++] = fastReader.nextInt();
			}

			sortByFrequency(arr);
		}
	}
}
