package Md_Arrays;

import java.util.Arrays;

public class TrapingRainWater {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };//6
		System.out.println(trap(arr));

	}

	public static int trap(int[] height) {
		if(height==null ||height.length==0)
			return 0;
	    final int left[] = new int[height.length];
	    final int right[] = new int[height.length];

	    left[0] = height[0];
	    right[0] = height[height.length - 1];
	    int maxLeft = height[0];
	    int maxRight = height[height.length - 1];
	    for (int i = 1; i < height.length; i++) {
	      if (height[i - 1] > maxLeft) {
	        maxLeft = height[i - 1];
	      }
	      left[i] = maxLeft;
	    }
	    for (int i = height.length - 2; i >= 0; i--) {
	      if (height[i + 1] > maxRight) {
	        maxRight = height[i + 1];
	      }
	      right[i] = maxRight;
	    }

	    int netArea = 0;
	    for (int i = 0; i < height.length; i++) {
	      final int temp = Math.min(left[i], right[i]) - height[i];
	      if (temp > 0) {
	        netArea = netArea + Math.min(left[i], right[i]) - height[i];
	      }
	    }
	    return netArea;
	  }
}
