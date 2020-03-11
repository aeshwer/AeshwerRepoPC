package Md_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/word-ladder/
/*Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5*/
public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Boolean visited[] = new Boolean[wordList.size()];
		Arrays.fill(visited, false);
		if (!wordList.contains(endWord)) {
			return 0;
		}

		int res = ladderLengthUtil(endWord, wordList, beginWord, 0, visited, Integer.MAX_VALUE);
		if (res != Integer.MAX_VALUE) {
			return res + 1;
		}
		return 0;

	}

	private static int ladderLengthUtil(String endWord, List<String> wordList, String searchWord, int count,
			Boolean[] visited, int result) {

		if (searchWord.equals(endWord)) {
			return Math.min(count, result);
		}

		for (int i = 0; i < wordList.size(); i++) {
			if (!visited[i] && checkIfOneCharDifferOrEqual(searchWord, wordList.get(i))) {
				if (result != Integer.MAX_VALUE && count > result) {
					continue;
				}
				visited[i] = true;
				result = ladderLengthUtil(endWord, wordList, wordList.get(i), count + 1, visited, result);
				visited[i] = false;
			}
		}
		return result;

	}

	private static boolean checkIfOneCharDifferOrEqual(String searchWord, String word) {
		int count = 0;
		if (searchWord.equals(word))
			return true;
		for (int i = 0; i < word.length(); i++) {
			if (searchWord.charAt(i) != word.charAt(i)) {
				count++;
			}
			if (count > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		List<String> asList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(ladderLength("hit", "cog", new ArrayList<String>(asList)));
	}
}
