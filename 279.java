public class Solution
{
	public int numSquares(int n)
	{
		if(n < 1)
			return -1;

		int [] dp = new int [n + 1];

		for(int i = 1;i < dp.length;i++)
		{
			dp[i] = i;

			for(int j = 1;j * j <= i;j++)
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
		}

		return dp[n];
	}
}