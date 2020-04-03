package LeetCode_Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {
	// There will be 3 kinds of check
	// 1 column check
	// row check
	// 3x3 block check
	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;

		for (int i = 0; i < board.length; i++) {
			Set<Character> columnLookup = new HashSet<>();
			Set<Character> rowLookup = new HashSet<>();
			for (int j = 0; j < board[0].length; j++) {
				// check for row data
				if (board[i][j] > '0' && board[i][j] <= '9') {
					if (rowLookup.contains(board[i][j]))
						return false;
					rowLookup.add(board[i][j]);
				}

				// check for column data
				if (board[j][i] > '0' && board[j][i] <= '9') {
					if (columnLookup.contains(board[j][i]))
						return false;
					columnLookup.add(board[j][i]);
				}
			}
		}

		// check for block
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Set<Character> blockLookup = new HashSet<>(9);
				for (int r = i * 3; r < 3 * i + 3; r++) {
					for (int c = j * 3; c < 3 * j + 3; c++) {
						if (board[r][c] > '0' && board[r][c] <= '9') {
							if (blockLookup.contains(board[r][c]))
								return false;
							blockLookup.add(board[r][c]);
						}
					}
				}

			}
		}

		return true;
	}

	public static void main(String[] args) {

		char[][] arr = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		if (isValidSudoku(arr)) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}
}
