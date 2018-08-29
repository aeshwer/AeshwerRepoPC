package TopArraysProblem;

import java.util.Arrays;
import java.util.BitSet;

public class FindMissingNumbers {
	//Solution 1
	/**
	 * Java method to find missing number in array of size n containing numbers from 1 to n only.
	 * can be used to find missing elements on integer array of  numbers from 1 to 100 or 1 - 1000
	 */
	private static int getMissingNumber(int[] numbers, int totalCount) {
		int expectedSum = totalCount * ((totalCount + 1) / 2);
		int actualSum = 0;
		for (int i : numbers) {
			actualSum += i;
		}

		return expectedSum - actualSum;
	}

	//Solution 2
	private static void printMissingNumber(int[] numbers, int count) 
	{ 
		int missingCount = count - numbers.length; 
		BitSet bitSet = new BitSet(count); 
		for (int number : numbers)
		{ 
			bitSet.set(number-1); // important step done to identity the bits having same value as index number or more than that 
		} 
		System.out.println("Missing numbers in integer array"+ Arrays.toString(numbers) +"  with total number "+ count+" is : "); 
		int lastMissingIndex = 0; 
		for (int i = 0; i < missingCount; i++) 
		{ 
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
		// Returns the index of the first bit that is set to false that occurs on or after the specified starting index.
			System.out.print(++lastMissingIndex+ "  " ); 
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		// one missing number
		printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
		// one missing number
		printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
		// three missing number
		printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
		// four missing number
		printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);
		// Only one missing number in array
		int[] iArray = new int[]{1, 2, 3, 5};
		int missing = getMissingNumber(iArray, 5);
		System.out.printf("Missing number in array %s is %d %n", Arrays.toString(iArray), missing);

	}

}
