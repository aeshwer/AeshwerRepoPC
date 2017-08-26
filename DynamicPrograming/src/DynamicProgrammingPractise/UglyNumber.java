/*
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 */
package DynamicProgrammingPractise;

public class UglyNumber {
	
	int ugly(int n){
        int arr[] = new int[n];
        int count = 1;
        arr[0] = 1;  // since 1st ugly number is 1
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(count < n){
            int minNumber = min(arr[i2] * 2, arr[i3] * 3, arr[i5] * 5);
            if(minNumber == arr[i2]*2){
                i2++;
            }
            if(minNumber == arr[i3]*3){
                i3++;
            }
            if(minNumber == arr[i5]*5){
                i5++;
            }
            arr[count++] = minNumber;
        }
        
        return arr[n-1];
    }
	
	private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
	
	public static void main(String[] args) {

		 	UglyNumber ugly = new UglyNumber();
	        int result = ugly.ugly(150);
	        System.out.println(result);
	}
}
