package SortingQuestions;

//Need a O(logn solution) - use 2 binary search to get first and last occurance
public class TotalOccuranceOfKInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 7, 7, 12, 12, 33 };
		int k = 1;
		totalOccuranceOfKInSortedArray(arr, k);

	}

	private static void totalOccuranceOfKInSortedArray(int[] arr, int k) {
		int firstOccurance = getIndexForFirstOccurance(arr, k, 0, arr.length);
		int lastOccurance = getIndexForLastOccurance(arr, k, 0, arr.length);
		System.out.println(lastOccurance-firstOccurance+1);
	}

	private static int getIndexForLastOccurance(int[] arr, int k, int l, int r) {
		if (l <= r) {
			int mid = l + (r - l) / 2;
			if(arr[mid]>k) {
				return getIndexForLastOccurance(arr, k, l,mid-1);
			}
			else if(arr[mid]>k) {
				return getIndexForLastOccurance(arr, k, mid+1,r);
			}
			else if(arr[mid]==k && mid+1 <arr.length && arr[mid+1]== k) {
				return getIndexForLastOccurance(arr, k,mid+1,r);
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	private static int getIndexForFirstOccurance(int[] arr, int k, int l, int r) {
		if (l <= r) {
			int mid = l + (r - l) / 2;
			if(arr[mid]>k) {
				return getIndexForFirstOccurance(arr, k, l,mid-1);
			}
			else if(arr[mid]>k) {
				return getIndexForFirstOccurance(arr, k, mid+1,r);
			}
			else if(arr[mid]==k && mid-1 >=0 && arr[mid-1]== k) {
				return getIndexForFirstOccurance(arr, k, l,mid-1);
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}
