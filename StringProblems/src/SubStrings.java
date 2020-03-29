import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://www.geeksforgeeks.org/java-lang-string-substring-java/
//O(n^2)
public class SubStrings {

	public static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return Integer.compare(o1.length(), o2.length());
		}
	}

	// Function to print all substring
	public static void SubString(String str, int n) {
		List<String> sortedList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				// Please refer below article for details of substr in Java
				sortedList.add(str.substring(i, j));
				// System.out.println(str.substring(i, j)); simple solution
			}
		}
		Collections.sort(sortedList, new StringComparator());
		// sortedList.sort(Comparator.comparingInt(String::length)); use above
		// implementation or use JAVA8
		System.out.println(sortedList);
	}

	public static void main(String[] args) {
		String str = "abcd";
		SubString(str, str.length());
	}

}
