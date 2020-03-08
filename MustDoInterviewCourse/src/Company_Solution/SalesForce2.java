package Company_Solution;

public class SalesForce2 {

	public static String getShiftedString(String s, int l, int r) {
		if (s.length() == 1 || l == r) {
			return s;
		}

		if (l > r) {
			return doLeftShift(s, l - r);
		} else {
			return doRightShift(s, r - l);
		}

	}

	private static String doRightShift(String s, int shift) {
		shift = shift % s.length();
		if (shift > 0) {
			StringBuilder str = new StringBuilder();
			str.append(s.substring(s.length() - shift, s.length())).append(s.substring(0, s.length() - shift));
			return str.toString();
		}
		return s;
	}

	private static String doLeftShift(String s, int shift) {
		shift = shift % s.length();
		if (shift > 0) {
			StringBuilder str = new StringBuilder();
			str.append(s.substring(shift, s.length())).append(s.substring(0, shift));
			return str.toString();
		}
		return s;

	}

	public static void main(String[] args) {
		System.out.println(getShiftedString("abcdef", 3, 0));
	}
}
