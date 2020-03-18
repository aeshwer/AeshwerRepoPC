package Company_Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Experitest {

	public static void main(String[] args) {

		System.out.println(solution("BALLOON"));

	}

	public static int solution(String S) {
		if (S.length() < 7) {
			return 0;
		}
		Map<Character, Integer> lookup = new HashMap<>();
		char[] input = S.toCharArray();
		// balloon -sample word
		char[] sampleText = { 'B', 'A', 'L', 'O', 'N' };
		int[] sampleTextFreq = { 1, 1, 2, 2, 1 };

		// map has freq count
		for (int i = 0; i < S.length(); i++) {

			if (!lookup.containsKey(input[i])) {
				lookup.put(input[i], 1);
			} else {
				lookup.put(input[i], lookup.get(input[i]) + 1);
			}
		}

		int count = Integer.MAX_VALUE;
		if (!lookup.containsKey('L')) {
			lookup.put('L', lookup.get('L') / 2);
		} else
			return 0;

		if (!lookup.containsKey('O')) {
			lookup.put('O', lookup.get('O') / 2);
		} else
			return 0;
		
		for (int i = 0; i < sampleText.length; i++) {
			 if(!lookup.containsKey(sampleText[i])) {
				 return 0;
			 }
			 else {
				 count =Math.min(count, lookup.get(sampleText[i]));
			 }
		}
		
		return count;

		/*while (true) {
			/*
			 * int i = 0; for (i = 0; i < sampleText.length; i++) { if
			 * (lookup.containsKey(sampleText[i])) { Integer freq =
			 * lookup.get(sampleText[i]); freq = freq - sampleTextFreq[i]; if (freq < 0)
			 * return count; lookup.put(sampleText[i], freq);
			 * 
			 * } else { return count; }
			 * 
			 * } count++;
			 }*/
	}

}
