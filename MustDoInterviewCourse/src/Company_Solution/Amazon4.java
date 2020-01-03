	package Company_Solution;
	
	import java.util.ArrayList;
	import java.util.List;
	
	public class Amazon4 {
	
		int minimumDays(int rows, int columns, List<List<Integer>> grid) {
	
			int count = 0;
			Boolean res = false;
	
			do {
				if(res)  break;
				count++;
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < columns; j++) {
	
						if (grid.get(i).get(j) == 0) {
	
							if (i > 0 && grid.get(i - 1).get(j) == 1) {
								grid.get(i).set(j, 1);
							}
	
							if (j > 0 && grid.get(i).get(j - 1) == 1) {
								grid.get(i).set(j, 1);
							}
							if (i < rows - 1 && grid.get(i + 1).get(j) == 1) {
								grid.get(i).set(j, 1);
							}
							if (j < columns - 1 && grid.get(i).get(j + 1) == 1) {
								grid.get(i).set(j, 1);
							}
						}
						if (grid.get(i).get(j) == 0) {
							res = true;
						}
	
					}
				}
			} while (res);
			return count;
		}
	
		public static void main(String[] args) {}
	}
