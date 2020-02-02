package Md_Arrays;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int arr1[] = { 1, 2 };
		int arr2[] = { 3, 4 };
		System.out.println("Median is : " + medianOfTwoSortedArrayInLogn(arr1, arr2));
	}

	private static double medianOfTwoSortedArrayInLogn(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		if (len1 <= len2) {
			return binarySearchOnSmallerArray(arr1, arr2, 0, len1);
		} else {
			return binarySearchOnSmallerArray(arr2, arr1, 0, len2);
		}
	}

	private static double binarySearchOnSmallerArray(int[] arr1, int[] arr2, int start, int end) {
		if (start <= end) {
			int partitionX = start + (end - start) / 2;
			int partitionY = (arr1.length + arr2.length + 1) / 2 - partitionX;

			// if partitionX is 0 it means nothing is there on left side. Use -INF for
			// maxLeftX
			// if partitionX is length of input then there is nothing on right side. Use
			// +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
			int minRightX = (partitionX == arr1.length) ? Integer.MAX_VALUE : arr1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
			int minRightY = (partitionY == arr2.length) ? Integer.MAX_VALUE : arr2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((arr1.length + arr2.length) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			}
			if (maxLeftX > minRightY) {
				return binarySearchOnSmallerArray(arr1, arr2, start, partitionX - 1);
			} else {
				return binarySearchOnSmallerArray(arr1, arr2, partitionX + 1, end);
			}
		}
		return 0d;

	}
}
