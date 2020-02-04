package Company_Solution;

import java.util.Arrays;
import java.util.List;

public class GoldManSachs2 {

	public static void main(String[] args) {
		Integer arr[] = { 10,-15,20,-25 };
		System.out.println(requiredAmountAtStart(Arrays.asList(arr)));

	}

	public static int requiredAmountAtStart(List<Integer> netSaving) {
		int initialMoney = 0;
		int currentMoney = 0;

		boolean flag = false;

		Integer[] arr = netSaving.toArray(new Integer[0]);

		for (int i = 0; i < arr.length; i++) {
			currentMoney = currentMoney + arr[i];
			if (currentMoney <= 0) {
				initialMoney = initialMoney + Math.abs(currentMoney) + 1;
				currentMoney = 1;
				flag = true;
			}

		}

		return flag ? initialMoney : 0;

	}
}
