public class Solution
{
	public int maxProfit(int k, int [] prices)
	{
		if(prices == null || prices.length < 2 || k < 1)
			return 0;

		int l = prices.length;

		if(k > l)
			return maxProfit(prices);

		int [][] local = new int [l][k + 1];
		int [][] global = new int [l][k + 1];

		for(int i = 1;i < l;i++)
		{
			int difference = prices[i] - prices[i - 1];

			for(int j = 1;j <= k;j++)
			{
				local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(difference, 0), local[i - 1][j] + difference);
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}

		return global[l - 1][k];
	}

	private int maxProfit(int [] prices)
	{
		int profit = 0;

		for(int i = 1;i < prices.length;i++)
		{
			int difference = prices[i] - prices[i - 1];

			if(difference > 0)
				profit += difference;
		}

		return profit;
	}
}