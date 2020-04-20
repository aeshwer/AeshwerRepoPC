package LeetCode_Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/
/*
 * Valid IP rules
 * 1) 4 sections with 3 digits max in any sections
 * 2) range of eeach section - 1- 255
 * 3) No leading zeros in a section
 */
public class RestoreIpAddress {

	public static List<String> restoreIpAddresses(String s) {
		List<String> resList = new ArrayList<String>();
		restoreIp(s, resList, 0, "", 0);
		return resList;
	}

	public static void restoreIp(String ip, List<String> resList, int idx, String restored, int sectionCount) {
		if (sectionCount > 4)
			return;
		if (sectionCount == 4 && idx == ip.length())
			resList.add(restored);

		for (int i = 1; i < 4; i++) {
			if (idx + i > ip.length())
				break;
			String s = ip.substring(idx, idx + i);
			if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256))
				continue;
			restoreIp(ip, resList, idx + i, restored + s + (sectionCount == 3 ? "" : "."), sectionCount + 1);
		}
	}

	public static void main(String[] args) {
		List<String> res = restoreIpAddresses("25525511135");
		res.forEach(v -> {
			System.out.println(v);
		});
	}
}
