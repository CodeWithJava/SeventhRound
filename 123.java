public class Solution
{
	public int maxProfit(int [] prices)
	{
		if(prices == null || prices.length < 2)
			return 0;

		int size = prices.length;

		int [] l = new int [size];
		l[0] = 0;
		int min = prices[0];

		for(int i = 1;i < size;i++)
		{
			min = Math.min(min, prices[i]);
			l[i] = Math.max(l[i - 1], prices[i] - min);
		}

		int [] r = new int [size];
		r[size - 1] = 0;
		int max = prices[size - 1];

		for(int i = size - 2;i >= 0;i--)
		{
			max = Math.max(max, prices[i]);
			r[i] = Math.max(r[i + 1], max - prices[i]);
		}

		int profit = 0;

		for(int i = 0;i < size;i++)
			profit = Math.max(profit, l[i] + r[i]);

		return profit;
	}
}