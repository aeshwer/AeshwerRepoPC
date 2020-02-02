package Company_Solution;

public class GoldManSachs1 {

	public static void main(String[] args) {
		System.out.println(collapseString("GGr777ttttGG"));
	}

	public static String collapseString(String inputString) {

		if (inputString.isEmpty()) {
			return "";
		}

		int count = 1;
		String result = "";
		char currentChar = inputString.charAt(0);

		for (int i = 1; i < inputString.length(); i++) {
			if (currentChar == inputString.charAt(i)) {
				count++;
			} else {
				result = result + count + currentChar;
				currentChar = inputString.charAt(i);
				count = 1;
			}
		}

		result = result + count + currentChar;
		return result;

	}
}
