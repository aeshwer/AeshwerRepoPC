package March28;

public class BuySellStock2 {

	public static int maxProfit(int[] prices) {
		if (prices == null)
			return 0;
		if (prices.length <= 1)
			return 0;
		int profit = 0;
		int buy = prices[0];
		for (int i = 1; i < prices.length; i++) {

			if (prices[i] > buy && i + 1 < prices.length && prices[i + 1] > prices[i]) {
				continue;
			}

			if (prices[i] > buy) {
				profit = profit + (prices[i] - buy);
				i++;
			}

			buy = i >= prices.length ? 0 : prices[i];
		}

		return profit;
	}

	public static void main(String[] args) {
		int[] prices = {};
		System.out.println(maxProfit(prices));
	}
}
