//https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem/0
//https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
package MustDoInterviewCourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class SnakeAndLadderProblem {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		//Constructor
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		List<Integer> board[] = new ArrayList[31];
		for (int i = 1; i < 31; i++) {
			for (int j = i + 1; j <= i + 6 && j < 31; j++) {
				if (board[i] == null) {
					board[i] = new ArrayList<Integer>();
				}
				board[i].add(j);
			}
		}
		while (t-- > 0) {
			int n = fr.nextInt();
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				int a = fr.nextInt();
				int b = fr.nextInt();
				map.put(a, b);
			}
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[] visited = new boolean[31];
			visited[1] = true;
			int count = 0;
			q.offer(1);
			q.offer(-1);
			while (q.size() > 0) {
				int temp = q.poll();
				if (temp == 30) {
					System.out.println(count);
					break;
				}
				if (temp == -1 && q.size() > 0 && q.peek() != -1) {
					count++;
					q.offer(-1);
				}
				if (temp != -1) {
					for (int i : board[temp]) {
						if (!visited[i] && i > temp) {
							if (map.containsKey(i))
								q.offer(map.get(i));
							q.offer(i);
							visited[i] = true;
						}
					}
				}
			}
		}
	}

}
