public class Solution
{
	public int numWays(int n, int k)
	{
		if(n <= 0 || k <= 0)
			return 0;

		int [] dp = {0, k, k * k, 0};

		if(n < 3)
			return dp[n];

		for(int i = 2;i < n;i++)
		{
			dp[3] = dp[1] * (k - 1) + dp[2] * (k - 1);
			dp[1] = dp[2];
			dp[2] = dp[3];
		}

		return dp[3];
	}
}