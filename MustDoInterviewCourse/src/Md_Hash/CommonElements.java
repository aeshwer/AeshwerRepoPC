package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CommonElements {

	public static class Counter {
		private int one;
		private int two;
		private int three;

		public Counter setOne(int one) {
			this.one = one;
			return this;
		}

		public Counter setTwo(int two) {
			this.two = two;
			return this;
		}

		public Counter setThree(int three) {
			this.three = three;
			return this;
		}

	}

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
			while (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}
	}

	private static void printCommonElements(int[] a1, int[] a2, int[] a3) {

		Map<Integer, Counter> lookup = new HashMap<>();
		boolean falseFlag = false;

		for (int i = 0; i < a1.length; i++) {
			lookup.put(a1[i], new Counter().setOne(one));
		}

		for (int i = 0; i < a2.length; i++) {
			if (lookup.containsKey(a2[i])) {
				lookup.put(a2[i], count.two++);
			}
		}

		for (int i = 0; i < a3.length; i++) {
			if (lookup.containsKey(a3[i])) {
				lookup.put(a3[i], count.three++);
			}
		}

		for (Map.Entry<Integer, Integer> l : lookup.entrySet()) {
			if (l.getValue().one == 3) {
				System.out.println(l.getKey() + " ");
				falseFlag = true;
			}
		}

		if (!falseFlag) {
			System.out.print(-1);
		}

	}

	public static void main(String[] args) {
		FastReader read = new FastReader();
		int cases = read.nextInt();

		while (--cases >= 0) {

			// line 1 input
			int n1 = read.nextInt();
			int n2 = read.nextInt();
			int n3 = read.nextInt();

			int a1[] = new int[n1];
			int a2[] = new int[n2];
			int a3[] = new int[n3];

			// line 2 input
			int i = 0;
			while (--n1 >= 0) {
				a1[i++] = read.nextInt();
			}

			i = 0;
			// line 3 input
			while (--n2 >= 0) {
				a2[i++] = read.nextInt();
			}

			i = 0;
			// line 4 input
			while (--n3 >= 0) {
				a3[i++] = read.nextInt();
			}

			printCommonElements(a1, a2, a3);
			System.out.println();
		}
	}

}
