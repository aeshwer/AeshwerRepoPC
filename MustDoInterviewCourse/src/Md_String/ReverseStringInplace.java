package Md_String;

public class ReverseStringInplace {

	public static char[] reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		// a =10 ,b =20
		// a =a+b => a =30 ,b =20
		// b = a-b => a =30 ,b =10
		// a = a-b => a =20 ,b =10

		while (left < right) {
			int a = Integer.valueOf(s[left]);
			int b = Integer.valueOf(s[right]);
			a = a + b;
			b = a - b;
			a = a - b;
			s[left] = (char) a;
			s[right] = (char) b;
			left++;
			right--;

		}
		return s;
	}

	public static void main(String[] args) {
		String str = "KANika";
		System.out.println("INPUT: " + str);
		System.out.println("OUTPUT: " + String.valueOf(reverseString(str.toCharArray())));
	}
}
