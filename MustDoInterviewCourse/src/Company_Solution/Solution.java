package Company_Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Solution {

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
		int n = fastReader.nextInt();

		Stack<Integer> stack = new Stack<>();

		while (--n >= 0) {
			String op = fastReader.nextLine();
			String[] split = op.split(" ");
			String operator = split[0];

			// switch (operator) {

			if (operator.equals("push")) {
				int val = Integer.parseInt(split[1]);
				stack.push(val);
			} else if (operator.equals("pop")) {
				if (stack.size() > 0) {
					stack.pop();
				}
			} else if (operator.equals("inc")) {
				int x = Integer.parseInt(split[1]);
				int d = Integer.parseInt(split[2]);
				int len = stack.size();
				for (int i = 0; i < x; i++) {
					Integer e = stack.get(i);
					e = e + d;
					stack.setElementAt(e, i);
				}

			}

			if (stack.size() > 0) {
				System.out.println(stack.peek());
			} else {
				System.out.println("EMPTY");
			}

		}
	}
}
