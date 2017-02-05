public class Solution
{
	public int numDistinct(String s, String t)
	{
		if((s == null || s.length() == 0) && (t == null || t.length() == 0))
			return 1;

		if(s == null || s.length() == 0)
			return 0;

		if(t == null || t.length() == 0)
			return 1;

		int m = t.length();
		int n = s.length();

		int [][] dp = new int [m + 1][n + 1];
		dp[0][0] = 1;

		for(int i = 1;i <= m;i++)
			dp[i][0] = 0;

		for(int j = 1;j <= n;j++)
			dp[0][j] = 1;

		for(int i = 1;i <= m;i++)
		{
			for(int j = 1;j <= n;j++)
			{
				dp[i][j] = dp[i][j - 1];

				if(t.charAt(i - 1) == s.charAt(j - 1))
					dp[i][j] += dp[i - 1][j - 1];
			}
		}

		return dp[m][n];
	}
}