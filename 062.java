public class Solution
{
	public int uniquePaths(int m, int n)
	{
		if(m < 1 || n < 1)
			return 0;

		int [][] dp = new int [m + 1][n + 1];
		dp[m][n - 1] = 1;

		for(int i = m - 1;i >= 0;i--)
			for(int j = n - 1;j >= 0;j--)
				dp[i][j] = dp[i][j + 1] + dp[i + 1][j];

		return dp[0][0];
	}
}