import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class UniqueCharacters {
	
	static boolean checkUniqueChar(String str){
		
		HashSet<Character> set = new HashSet<Character>();
		int len = str.length();
		for(int i=0; i<len ;i++)
		{
			// if set dont contain the character then add that to set
			if(!set.contains(str.charAt(i)))
			{
				set.add(str.charAt(i));
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string");
		String  str = read.readLine();
		
		System.out.println("Enter string is :: " + str);
		System.out.println("The string is unique :: "+  checkUniqueChar(str));		
	}
}
