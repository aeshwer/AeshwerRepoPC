/*
 * http://www.geeksforgeeks.org/longest-common-substring/
 */
package DynamicProgrammingPractise;

public class LongestCommonSubString {
	
	private static int LCSubStr(char[] str1, char[] str2, int len1 ,int len2) {
		int temp[][] = new int[len1 + 1][len2 + 1];
        int max = 0;
        for(int i=1; i < len1+1; i++){
            for(int j=1; j < len2+1; j++){
            	if( str1[i-1]== str2[j-1])
            	{
            		//temp[i][j] = Math.max(temp[i-1][j], Math.max(temp[i][j-1], temp[i-1][j-1]))+1; 
            		temp[i][j] = temp[i-1][j-1]+1;
            	}
            	else
            	{
            		temp[i][j] = 0;
            	}
            	max = temp[i][j] > max ? temp[i][j]: max; 
            }
        }
        return max;
	}

	public static void main(String[] args) {
	//String str1 = "OldSite:GeeksforGeeks.org";
    //String str2 = "NewSite:GeeksQuiz.com";
    
    String str1 = "DABCZ";
    String str2 = "ABCDZ";

    int len1 = str1.length();
    int len2 = str2.length();

    System.out.println("Length of Longest Common Substring is " + LCSubStr(str1.toCharArray(), str2.toCharArray(), len1, len2));
	}
}
