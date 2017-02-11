public class Solution
{
	public int getMoneyAmount(int n)
	{
		if(n < 1)
			return 0;

		int [][] dp = new int [n + 1][n + 1];

		return solve(1, n, dp);
	}

	private int solve(int l, int r, int [][] dp)
	{
		if(l >= r)
			return 0;

		if(dp[l][r] > 0)
			return dp[l][r];

		dp[l][r] = Integer.MAX_VALUE;

		for(int i = l;i <= r;i++)
			dp[l][r] = Math.min(dp[l][r], i + Math.max(solve(l, i - 1, dp), solve(i + 1, r, dp)));

		return dp[l][r];
	}
}