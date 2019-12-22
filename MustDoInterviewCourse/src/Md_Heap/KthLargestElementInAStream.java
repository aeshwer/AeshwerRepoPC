package Md_Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KthLargestElementInAStream {

	public static class FastReader {
		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		private String next() {
			if (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
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

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();
		while (--cases >= 0) {
			int k = fastReader.nextInt();
			int n = fastReader.nextInt();
			int arr[] = new int[n];
			int index = 0;
			while (--n >= 0) {
				arr[index++] = fastReader.nextInt();
			}
			getKthLargestElement(arr, arr.length, k);
		}
	}

	private static void getKthLargestElement(int[] arr, int n, int k) {
		if (arr == null || arr.length == 0)
			return;
		PriorityQueue<Integer> pq = new PriorityQueue<>(k);
		for (int i = 0; i < n; i++) {
			if (pq.size() < k) {
				pq.add(arr[i]);
				if (pq.size() == k)
					System.out.print(pq.peek() + " ");
				else
					System.out.print("-1 ");
			} else if (pq.size() == k) {
				if (arr[i] <= pq.peek())
					System.out.print(pq.peek() + " ");
				else {
					pq.poll();
					pq.add(arr[i]);
					System.out.print(pq.peek() + " ");
				}
			}
		}
		System.out.println();

	}
}
