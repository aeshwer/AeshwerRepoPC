package MustDoInterviewCourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLAdderSol2 {

    public static int find(int[] board)
    {
        int[] dist= new int[100];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        Queue<Integer> q= new LinkedList<Integer>();
    //Queue<Integer> q = new LinkedList<>(); 
        q.add(1);
        while(true)
        {
            int front=q.peek();
            if(front==30)
            break;
            q.remove();
            for(int i=front+1;i<=front+6 && i<=30;i++)
            {
                if(board[i]==0)
                {
                    dist[i]=Math.min(dist[i],dist[front]+1);
                    q.add(i);
                }
                else
                {
                    dist[board[i]]=Math.min(dist[board[i]],dist[front]+1);
                    q.add(board[i]);
                }
            }
        }
        return dist[30];
    }
	public static void main (String[] args) throws IOException{
	    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	    Scanner sc=new Scanner(System.in);
	    int t=Integer.parseInt(br.readLine());
	    
	    while(t-->0)
	    {
	        
	        int n=Integer.parseInt(br.readLine());
	     String line=br.readLine();
	        String[] str= line.trim().split("\\s");
	        int[] board=new int[100];
	        for(int i=0;i<100;i++)
	        board[i]=0;
	         int i=1;
	         while(i<=2*n)
	   {
	         int b=Integer.parseInt(str[i]);
	         int a=Integer.parseInt(str[i-1]);
	            board[a]=b;
	           // System.out.print(a+" "+b);
	            i+=2;
	    }
	            
	       int res=find(board);
	       System.out.println(res);
	    }
		//code
	}


}
