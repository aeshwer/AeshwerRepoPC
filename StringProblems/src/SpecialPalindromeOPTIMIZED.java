/*A string is said to be a special palindromic string if either of two conditions is met:
1)All of the characters are the same, e.g. aaa.
2)All characters except the middle one are the same, e.g. aadaa.
A special palindromic substring is any substring of a string which meets one of those criteria. Given a string, determine how many special palindromic substrings can be formed from it.
For example, given the string s ="asasd" o/p={a,s,a,s,d,asa,sas }, 
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
// OPTIMIZES SOLUTION
//https://www.geeksforgeeks.org/count-special-palindromes-in-a-string/    
public class SpecialPalindromeOPTIMIZED {
	private static final Scanner scanner = new Scanner(System.in);

	static long substrCount(int n, String s) {
		int minimumCount = s.length();
		
		for(int i = 0 ;i< s.length();i++) 
		{
			for(int j = i+1 ;j< s.length();j++)
				minimumCount = minimumCount + IsSpecialPalindrome(s.substring(i, j+1));
		}
		return minimumCount;

	}

	private static int IsSpecialPalindrome(String substring) {
		//checking condition 1 : all same alphabets except one on center
		boolean countConditionOne = false;
		
		if(substring.length()%2 != 0) 
		{ 	int mid =  substring.length()/2;
			for(int i = 0 ;i< mid;i++) 
			{
				if((substring.charAt(i)==substring.charAt(mid+1))) 
				{
					countConditionOne = true;
				}
				else
				{
					countConditionOne = false;
					break ;
				}
			}
		}
		if(countConditionOne==true ) {return 1;}
		
		//checking condition 2 : all same alphabets
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < substring.length(); i++)
        {
            //Getting char from substring
            char charAsKey = substring.charAt(i);
            int charCountAsValue = 0;
            if(map.containsKey(charAsKey))
            {
                charCountAsValue = map.get(charAsKey);
            }
            //Putting char and it's count to map with pre-incrementing char count
            map.put(charAsKey, ++charCountAsValue);
        }
		boolean countConditionTwo = false;
		for(int values: map.values()) 
		{
			if(values >= 1) {
				if(countConditionTwo==true ) {return 0;}
				countConditionTwo=true;
				}
		}
		if(countConditionTwo==true ) {return 1;}
		return 0;
	}

	public static void main(String[] args) throws IOException {
/*
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String s = scanner.nextLine();
		long result = substrCount(n, s);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();*/
		
		String s3= "aaaa";
		//String s3= "abcbaba";
		System.out.println(s3+ " "+ substrCount(0,s3));
		
	}
}

