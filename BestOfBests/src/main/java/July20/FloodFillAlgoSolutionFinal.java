//https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
//covering diagonals and avoiding repeated recursion
package July20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FloodFillAlgoSolutionFinal {

	static void process(int n,int m,int x,int y,int a[][],int k){
	     if(x>=n || y>=m || x<0 || y<0){
	         return;
	     }
	     int value = a[x][y];
	     a[x][y]=k;
	     if(x>0 && value==a[x-1][y]){//up
	         process(n,m,x-1,y,a,k);
	     }
	     if(x<n-1 && value==a[x+1][y]){//down
	         process(n,m,x+1,y,a,k);
	     }
	     if(y>0 && value==a[x][y-1]){//left
	         process(n,m,x,y-1,a,k);
	     }
	     if(y<m-1 && value == a[x][y+1]){//right
	         process(n,m,x,y+1,a,k);
	     }
	 }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String inp[] = br.readLine().split(" ");
			int n = Integer.parseInt(inp[0]);
			int m = Integer.parseInt(inp[1]);
			String input[] = br.readLine().split(" ");
			int a[][] = new int[n][m];
			int l = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = Integer.parseInt(input[l]);
					l++;
				}
			}
			String inputA[] = br.readLine().split(" ");
			int x = Integer.parseInt(inputA[0]);
			int y = Integer.parseInt(inputA[1]);
			int k = Integer.parseInt(inputA[2]);
			process(n,m,x,y,a,k);
    	    for(int i=0;i<n;i++){
    	        for(int j=0;j<m;j++){
    	            System.out.print(a[i][j]+" ");
    	        }
    	    }
    	    System.out.println();
		}
	}
}
