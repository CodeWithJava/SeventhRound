public class Solution
{
	public int maxProfit(int [] prices)
	{
		if(prices == null || prices.length == 0)
			return 0;

		int profit = 0;

		for(int i = 1;i < prices.length;i++)
		{
			int d = prices[i] - prices[i -1];

			if(d > 0)
				profit += d;
		}

		return profit;
	}
}