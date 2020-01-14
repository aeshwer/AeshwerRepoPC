package Md_String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0/?track=md-string&batchId=144
// Code from crazyDeveloper
public class RomanToInteger {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			int n = str.length();
			int res = 0;
			RomanToInteger obj = new RomanToInteger();
			for (int j = 0; j < n; j++) {
				int s1 = obj.value(str.charAt(j));
				if (j + 1 < str.length()) {
					int s2 = obj.value(str.charAt(j + 1));
					if (s1 >= s2)
						res = res + s1;
					else {
						res = res + s2 - s1;
						j++;
					}
				} else {
					res = res + s1;
					j++;
				}
			}
			System.out.println(res);
		}
	}

	int value(char ch) {
		if (ch == 'I')
			return 1;
		if (ch == 'V')
			return 5;
		if (ch == 'X')
			return 10;
		if (ch == 'L')
			return 50;
		if (ch == 'C')
			return 100;
		if (ch == 'D')
			return 500;
		if (ch == 'M')
			return 1000;
		return -1;
	}
}