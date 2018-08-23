import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://www.geeksforgeeks.org/java-lang-string-substring-java/
//O(n^2)
public class SubStrings {

	// Function to print all substring
	public static void SubString(String str, int n)
	{
		List<String> sortedList = new ArrayList<>();
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = i+1; j <= n; j++) 
			{
				// Please refer below article for details of substr in Java
				sortedList.add(str.substring(i, j));
				//System.out.println(str.substring(i, j)); simple solution
			}
		}
		sortedList.sort(Comparator.comparingInt(String::length));
        System.out.println(sortedList);
	}

	public static void main(String[] args) {
		String str = "abcd";
		SubString(str, str.length());
	}

}
