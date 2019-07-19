package July18;

import java.util.Arrays;
import java.util.Scanner;

public class AceeptTwoDArrayInput {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		while (--cases >= 0) {
			int n = s.nextInt();
			int arr[][] = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j]= s.nextInt();
				}
			}
			System.out.println(Arrays.deepToString(arr));
		}
	}

}
