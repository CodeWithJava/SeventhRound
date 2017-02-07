public class Solution
{
	public int maxCoins(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int l = nums.length;
		int [] x = new int [l + 2];
		x[0] = 1;
		x[l + 1] = 1;

		for(int i = 0;i < l;i++)
			x[i + 1] = nums[i];

		int [][] dp = new int [l + 2][l + 2];

		return traversal(1, l, x, dp);
	}

	private int traversal(int l, int r, int [] x, int [][] dp)
	{
		if(dp[l][r] > 0)
			return dp[l][r];

		for(int i = l;i <= r;i++)
			dp[l][r] = Math.max(dp[l][r], traversal(l, i - 1, x, dp) + x[l - 1] * x[i] * x[r + 1] + traversal(i + 1, r, x, dp));

		return dp[l][r];
	}
}