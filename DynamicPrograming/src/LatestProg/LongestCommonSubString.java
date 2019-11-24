package LatestProg;

public class LongestCommonSubString {

	public static void main(String[] args) {
		String s1 = "aabcdaf";
		String s2 = "zbcdf";
		Result result = findLongestCommonSubstring(s1, s2);
		System.out.println("LongestCommonSubstring length : " + result.length);
	}

	private static Result findLongestCommonSubstring(String s1, String s2) {
		int row = s1.length() + 1;
		int col = s2.length() + 1;

		int t[][] = new int[row][col];
		Result result = new Result();

		// fill base case 1st row and column

		// fill matrix as per formula
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = 0;
				}
				if (t[i][j] > result.length) {
					result.length = t[i][j];
					result.rowIndex = i;
					result.columnIndex = j;
				}

			}
		}
		System.out.println("LongestCommonSubstring in reverse order : ");
		
		//print the substring
		while(t[result.rowIndex][result.columnIndex]!=0)
		{
			System.out.print(s1.charAt(result.rowIndex-1) );
			result.rowIndex--;
			result.columnIndex--;
		}
		System.out.println();
		return result;
	}

	static class Result {
		int length;
		int rowIndex;
		int columnIndex;

		public Result() {
			this.length = 0;
			this.rowIndex = 0;
			this.columnIndex = 0;
		}

		public int getRes() {
			return length;
		}

		public void setRes(int res) {
			this.length = res;
		}

		public int getRowIndex() {
			return rowIndex;
		}

		public void setRowIndex(int rowIndex) {
			this.rowIndex = rowIndex;
		}

		public int getColumnIndex() {
			return columnIndex;
		}

		public void setColumnIndex(int columnIndex) {
			this.columnIndex = columnIndex;
		}

	}
}
