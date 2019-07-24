//ARRAYS ARE SORTED
//https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class CommonElements {

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

	private static void printCommonElements(int[] ar1, int[] ar2, int[] ar3) {
		
		// we dont need to output repeated elements 
		Set<Integer> set = new LinkedHashSet<>();
		boolean noOutputFlag =true;
		// Initialize starting indexes for ar1[], ar2[] and ar3[] 
        int i = 0, j = 0, k = 0;
        
        // Iterate through three arrays while all arrays have elements 
        while (i < ar1.length && j < ar2.length && k < ar3.length) 
        { 
             // If x = y and y = z, print any of them and move ahead 
             // in all arrays 
             if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) 
             {   set.add(ar1[i]);
            	 //System.out.print(ar1[i]+" ");   
             	  i++; j++; k++;
             	noOutputFlag = false;
             } 
  
             // x < y 
             else if (ar1[i] < ar2[j]) 
                 i++; 
  
             // y < z 
             else if (ar2[j] < ar3[k]) 
                 j++; 
  
             // We reach here when x > y and z < y, i.e., z is smallest 
             else
                 k++; 
        } 
        
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) 
        {
        	System.out.print(iterator.next() + " ");
        }
        
        if(noOutputFlag) {
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
