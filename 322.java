// Solution One
// Pay attention to the line 17 and line 18 for avoiding the overflow of index of array.
public class Solution
{
	public int coinChange(int [] coins, int amount)
	{
		if(coins == null || coins.length == 0 || amount < 0)
			return -1;

		int [] dp = new int [amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for(int i = 0;i < dp.length;i++)
		{
			for(int coin: coins)
				if(coin <= i)
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
		}

		return dp[amount] == amount + 1 ? -1: dp[amount];
	}
}

// Solution Two
// Pay attention to the line 42 for avoiding the overflow of index of array.
// Corner case: [1, Integer.MAX_VALUE], 2
public class Solution
{
	public int coinChange(int [] coins, int amount)
	{
		if(coins == null || coins.length == 0 || amount < 0)
			return -1;

		int [] dp = new int [amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for(int i = 0;i < dp.length;i++)
		{
			for(int coin: coins)
				if(i + coin <= amount && i + coin >= 0)
					if(dp[i] != amount + 1)
						dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
		}

		return dp[amount] == amount + 1 ? -1:dp[amount];
	}
}