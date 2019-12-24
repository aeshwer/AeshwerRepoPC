package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class FindAllFourSum {

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

		Long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	public static class Pairs {

		int second;
		int first;

		public Pairs(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	private static void findQuadrapleSumElements(int[] arr, int k) {
		Map<Integer, Pairs> lookup = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				lookup.put(arr[i] + arr[j], new Pairs(i, j));
			}
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				int sum = arr[i] + arr[j];

				if (lookup.containsKey(k - sum)) {

					Pairs pairs = lookup.get(k - sum);
					if (pairs.first != i && pairs.first != j && pairs.second != i && pairs.second != j) {
						List<Integer> list = new ArrayList<>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[pairs.first]);
						list.add(arr[pairs.second]);
						Collections.sort(list);
						result.add(list);
					}
				}

			}
		}

		// Print result
		
		
		result = removeDuplicates(result);
		Collections.sort(result, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// + Integer.compare(o1.get(2), o2.get(2)) + Integer.compare(o1.get(3),
				// o2.get(3));
				if (Integer.compare(o1.get(0), o2.get(0)) != 0) {
					return Integer.compare(o1.get(0), o2.get(0));
				} else if (Integer.compare(o1.get(1), o2.get(1)) != 0) {
					return Integer.compare(o1.get(1), o2.get(1));
				} else if (Integer.compare(o1.get(2), o2.get(2)) != 0) {
					return Integer.compare(o1.get(2), o2.get(2));
				} else {
					return Integer.compare(o1.get(3), o2.get(3));
				}
			}
		});

		result.forEach(list -> {
			list.forEach(innerListValue -> {
				System.out.print(innerListValue + " ");
			});
			System.out.print("$");
		});

		if (result.isEmpty()) {
			System.out.print(-1);
		}
	}
	
	 // Function to remove duplicates from an ArrayList 
    public static <T> List<T> removeDuplicates(List<T> list) 
    { 
    	
        // Create a new LinkedHashSet 
        Set<T> set = new LinkedHashSet<>(); 
        // Add the elements to set 
        set.addAll(list); 
        // Clear the list 
        list.clear(); 
        // add the elements of set 
        // with no duplicates to the list 
        list.addAll(set); 
        // return the list 
        return list; 
    } 

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			int index = 0;
			int arr[] = new int[n];
			while (--n >= 0) {
				arr[index++] = fastReader.nextInt();
			}
			findQuadrapleSumElements(arr, k);
			System.out.println();
		}
	}

}
