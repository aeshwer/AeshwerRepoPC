package Md_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		//Base error cases
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {

		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> groupAnagrams = groupAnagrams(input);

		for (List<String> list : groupAnagrams) {
			for (String val : list) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
}
