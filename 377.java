public class Solution
{
	public int combinationSum4(int [] nums, int target)
	{
		if(nums == null || nums.length == 0 || target < 0)
			return 0;

		int [] dp = new int [target + 1];
		dp[0] = 1;

		for(int i = 0;i <= target;i++)
			for(int x: nums)
				if(i + x <= target)
					dp[i + x] += dp[i];

		return dp[target];
	}
}