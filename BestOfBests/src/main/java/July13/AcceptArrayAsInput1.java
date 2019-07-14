//https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0
package July13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AcceptArrayAsInput1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(read.readLine());
		
		while(--cases >= 0) {
			String inputLine1 = read.readLine();
			int n =Integer.parseInt(inputLine1.substring(0, 1));
			int k =Integer.parseInt(inputLine1.substring(2, 3));
			
			int arr[] = new int[n];
			
	         String[] splitString = read.readLine().split(" ");
	         int i=0;
	         for(String str:splitString){
	        	 arr[i]=Integer.parseInt(str.trim());
	             i++;
	         }
			
	         arr.clone();
		}
	}
}
