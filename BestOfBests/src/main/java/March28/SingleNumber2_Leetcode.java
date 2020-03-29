package March28;

//https://leetcode.com/problems/single-number-ii/
//https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
public class SingleNumber2_Leetcode {

	public static int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) { //Extract LSB and check if 1
					sum++;
					sum %= 3;
				}
			}
			if (sum == 1) {
				ans |= sum << i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 3, 2, 3, 3, 2, 2, 8 };
		System.out.println(" The Number which occur one time is : " + singleNumber(nums));
	}
}
