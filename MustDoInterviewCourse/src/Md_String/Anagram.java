package Md_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Anagram {

	public static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			if (token == null || !token.hasMoreTokens()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();

		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	private static void checkAnagramString(String s1, String s2) {
        if(s1.length() != s2.length())
        {	
            System.out.println("NO");
            return;
        }
        else{
        	
        	 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
             for (int i = 0; i < s1.length(); i++)
             {
            	 	char charAt1 = s1.charAt(i);
            	 	 if(map.containsKey(charAt1))
                     {
                         //If contains, retrieving it's count
                         map.put(charAt1, map.get(charAt1)+1);
                     }
            	 	 else {
            	 		map.put(charAt1, 1);
            	 	 }
            	 	 
            	 	char charAt2 = s2.charAt(i);
            	 	 if(map.containsKey(charAt2))
                     {
                         //If contains, retrieving it's count
                         map.put(charAt2, map.get(charAt2)-1);
                     }
            	 	 else {
            	 		map.put(charAt1, -1);
            	 	 }
             }
             
             for(int value : map.values()) 
             {
            	 if(value != 0)
                 {
                     System.out.println("NO");
                     return;
                 }
             }
             
             System.out.println("YES");
        }

	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			String[] input = fastReader.nextLine().split(" ");
			String s1 = input[0];
			String s2 = input[1];

			checkAnagramString(s1, s2);
		}
	}

}
