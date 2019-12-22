package Md_Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0/?track=md-heap&batchId=144
/*Learn First how to find median of a numbers
if odd numbers  : median is middle number
if even numbers : median is average of middle 2 numbers*/

//Logic-- see explanination
public class MedianInStream {

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
		int totalElementsInStream = fastReader.nextInt();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		while (--totalElementsInStream >= 0) {
			maxHeap.add(fastReader.nextInt());
			minHeap.add(maxHeap.poll());
			if (maxHeap.size() < minHeap.size())
				maxHeap.offer(minHeap.poll());
			if (maxHeap.size() == minHeap.size())
				System.out.println((maxHeap.peek() + minHeap.peek()) / 2);
			else
				System.out.println(maxHeap.peek());
		}
	}

}
