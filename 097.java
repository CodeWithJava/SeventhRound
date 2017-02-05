public class Solution
{
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0) && (s3 == null || s3.length() == 0))
			return true;

		if(s3 == null || s3.length() == 0)
			return false;

		if((s1 == null || s1.length() == 0) && s2.equals(s3))
			return true;

		if((s2 == null || s2.length() == 0) && s1.equals(s3))
			return true;

		if(s1.length() + s2.length() != s3.length())	
			return false;

		int x = s1.length();
		int y = s2.length();

		boolean [][] dp = new boolean [x + 1][y + 1];
		dp[0][0] = true;

		for(int i = 1;i <= x && s1.charAt(i - 1) == s3.charAt(i - 1);i++)
			dp[i][0] = true;

		for(int j = 1;j <= y && s2.charAt(j - 1) == s3.charAt(j - 1);j++)
			dp[0][j] = true;

		for(int i = 1;i <= x;i++)
		{
			for(int j = 1;j <= y;j++)
			{
				char c = s3.charAt(i + j - 1);

				if(s1.charAt(i - 1) == c && dp[i - 1][j])
					dp[i][j] = true;

				if(s2.charAt(j - 1) == c && dp[i][j - 1])
					dp[i][j] = true;
			}
		}

		return dp[x][y];
	}
}