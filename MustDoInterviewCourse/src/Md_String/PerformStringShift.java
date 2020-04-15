package Md_String;

public class PerformStringShift {

	public static String stringShift(String s, int[][] shift) {

		for (int i = 0; i < shift.length; i++) {
			s = perfromShifts(shift[i][0] % s.length(), shift[i][1], s);
		}

		return s;

	}

	private static String perfromShifts(int direction, int amount, String s) {
		if (amount > 0)
			return direction == 0 ? leftShift(amount, s) : rightShift(amount, s);
		else
			return s;
	}

	private static String leftShift(int amount, String s) {
		s = s.substring(amount, s.length()) + s.substring(0, amount);
		System.out.println(s);
		return s;
	}

	private static String rightShift(int amount, String s) {
		s = s.substring((s.length() - amount)) + s.substring(0, s.length() - amount);
		System.out.println(s);
		return s;
	}

	public static void main(String[] args) {
		int[][] shift = { {1,1},{1,1},{0,2},{1,3}};
		System.out.println(stringShift("abcdefg", shift));
	}
}
