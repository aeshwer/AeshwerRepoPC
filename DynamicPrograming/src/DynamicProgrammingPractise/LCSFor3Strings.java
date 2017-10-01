package DynamicProgrammingPractise;

public class LCSFor3Strings {
	
	public static int lcsDynamic(char str1[],char str2[],char str3[],int len1 ,int len2, int len3){
		int temp[][][] = new int[len1 + 1][len2 + 1][len3 + 1];
        int max = 0;
        for(int i=1; i < len1+1; i++){
            for(int j=1; j < len2+1; j++){
            	for(int k=1; k < len3+1; k++){
            		if(str1[i-1] == str2[j-1] &&  str2[j-1] == str3[k-1]) {
            			temp[i][j][k] = temp[i - 1][j - 1][k - 1] + 1;
            		}
            		else
            		{
            			temp[i][j][k] = Math.max(temp[i][j-1][k],Math.max(temp[i-1][j][k],temp[i][j][k-1]));
            		}
            		if(temp[i][j][k] > max){
            			max = temp[i][j][k];
            		}
            	}
           	}
        }
        return max;
	}		

	public static void main(String[] args) {

        String str1 = "AGGT12";
        String str2 = "12TXAYB";
        String str3= "12XBA";
        
        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();
        
        int result = lcsDynamic(str1.toCharArray(), str2.toCharArray(),str3.toCharArray(),len1,len2,len3);
        System.out.print(result);
	}

}
