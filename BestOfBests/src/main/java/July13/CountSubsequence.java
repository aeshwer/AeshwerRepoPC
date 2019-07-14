//Count subsequences of type a^i b^j c^k
//https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck/0

/*solution

ac = current # of ways to select at least one a
bc = current # of ways to select at least one a followed by at least one b
cc = current # of ways to select at least one a followed by at least one b followed by at least one c

Explanation of above logic using bc = ac+2*bc:
When coming across a new 'b', consider all combinations counted by ab thus far. All of those combinations are still
valid plus each one of those combinations with the newly discovered 'b' at the end. This is why our bc assignment needs
to have 2*bc as part of the sum.

The other part of the sum is ac. Everything counted thus far has at least one of the previously seen 'b's but having 
just seen a new 'b', we must consider all of the "a^i b^j" combinations where /none/ of the previous b's are used. 
This is equivalent to the number of ways you can select at least one previously seen 'a' because each of those grouping of 'a's can now be paired with the newly found 'b'.

This explanation is for bc=ac+2*bc but can be extended in either direction to describe ac=1+2*ac and cc=bc+2*cc.

*/
package July13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountSubsequence {
	
	private static Integer resolveString(String str) {
			int n = str.length();
			int acount=0, bcount=0, ccount=0;
			
			  for (int i=0; i < n; i++) {
			        char ch = str.charAt(i);
			        if (ch == 'a') acount = 1 + 2*acount;
			        else if (ch == 'b') bcount = acount + 2*bcount;
			        else if (ch == 'c') ccount = bcount + 2*ccount;
			    }
			
			return ccount;
	}
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number of testcase");
		int cases = Integer.parseInt(read.readLine());
		
		List<Integer> result = new ArrayList<Integer>();
		
		while(--cases >= 0){
			result.add(resolveString(read.readLine()));
		}
		
		for(Integer r : result) {
			System.out.println(r);
		}
	}

	
}