public class Solution
{
	public int numDecodings(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		int [] dp = new int [s.length() + 1];
		dp[0] = 1;

		if(isValid(s.substring(0, 1)))
			dp[1] = 1;
		else
			dp[1] = 0;

		for(int i = 2;i < dp.length;i++)
		{
			if(isValid(s.substring(i - 1, i)))
				dp[i] += dp[i - 1];

			if(isValid(s.substring(i - 2, i)))
				dp[i] += dp[i - 2];
		}

		return dp[s.length()];
	}

	private boolean isValid(String s)
	{
		if(s.charAt(0) == '0')
			return false;

		int value = Integer.valueOf(s);

		return value >= 1 && value <= 26;
	}
}