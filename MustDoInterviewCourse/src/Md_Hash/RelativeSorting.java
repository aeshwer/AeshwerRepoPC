//https://practice.geeksforgeeks.org/problems/relative-sorting/0/?track=md-hashing&batchId=144
package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class RelativeSorting {

	public static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (token == null || !token.hasMoreTokens()) {
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

		Double nextDouble() {
			return Double.parseDouble(next());
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

	private static void resolveRealtiveSorting(Integer[] a1, Integer[] a2) {
		
		Map<Integer, Integer> map = new TreeMap<>();
		
		for(Integer itr: a1) {
			if(!map.containsKey(itr)) {
				map.put(itr,1);
			}
			else {
				map.put(itr, map.get(itr)+1);
			}
		}
		
		//Can Also use Java 8 style
		/*Map<Integer, Integer> map = new TreeMap<>(); // map to keep count in sorted order
        for(int itr: a1) {
        	map.merge(itr, 1, Integer::sum); // if exist increment count
        }*/
		
		
		
		for(int i=0;i<a2.length;i++) {
			if(map.containsKey(a2[i])) {
				Integer count = map.get(a2[i]);
				map.put(a2[i], 0);
				while(--count>=0) {
					System.out.print(a2[i]+" ");
				}
			}
			
		}
		
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			Integer c = entry.getValue();
			if(c!=0) {
				while(--c>=0) {
					System.out.print(entry.getKey()+" ");
				}
			}
		} 
		

	}

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();

			Integer a1[] = new Integer[n];
			Integer a2[] = new Integer[m];

			int i = 0;
			while (--n >= 0) {
				a1[i++] =fastReader.nextInt();
			}
			i=0;
			while (--m >= 0) {
				a2[i++] = fastReader.nextInt();
			}

			resolveRealtiveSorting(a1, a2);
			System.out.println();
		}
	}

}
