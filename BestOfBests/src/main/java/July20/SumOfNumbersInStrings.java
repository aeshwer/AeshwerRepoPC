//https://practice.geeksforgeeks.org/problems/sum-of-numbers-in-string/0

//NOTE:
//Observe how to get int value from a char----- Character.gerNumericValue(char)
//Observe how to get ascii value from char----- ((int)char)

package July20;

import java.util.Scanner;

public class SumOfNumbersInStrings {

	private static void resolve(String input) {
		int sum = 0;
		int exponent =1;
		for (int i =  input.length()-1; i >=0; i--) {
			if (checkIfNumber(input.charAt(i))) {
				
				sum+= (Character.getNumericValue(input.charAt(i)))*exponent;
				exponent=exponent*10;
			}
			else {
				exponent=1;
			}
		}
		System.out.println(sum);
	}

	private static boolean checkIfNumber(char charAt) {
		int value = (int) charAt;
		if (value >= 48 && value <= 57) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();

		while (--cases >= 0) {
			String str = s.next();
			resolve(str);
		}
	}
}
