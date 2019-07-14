package July14;

import java.util.Scanner;

public class SumOfBitsDifferenceSol2 {

		public static void main (String[] args)
		 {
	        Scanner sc=new Scanner(System.in);
		    int tc=sc.nextInt();
		        while(tc--!=0)
		        {
		            int n=sc.nextInt();
		            int ar[]=new int[n];
		            for(int x=0; x<n; x++)
		                ar[x]=sc.nextInt();
		            
		            int sum=0;
		            for(int x=0; x<n-1; x++)
		            {
		                for(int y=x+1; y<n; y++)
		                {
		                    int bits=0;
		                    int diff=ar[x]^ar[y]; //bitwise XOR (even =0 and odd=1 )
		                    while(diff>0)
		                    {
		                        diff=diff & (diff-1); // this logic helps cpunt number of ones
		                        bits++;
		                    }
		                    //multiplied by 2 to get results for pairs in one go...ie - pair(1,2)and (2,1) are same...so also reduced looping order
		                    sum=sum+(2*bits);
		                }
		            }
		            System.out.println(sum);
		            
		        }   
		        
		 }
}
