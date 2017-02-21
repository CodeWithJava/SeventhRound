// Solution One
public class Solution
{
	int count;

	public int findTargetSumWays(int [] nums, int S)
	{
		if(nums == null || nums.length == 0)
			return 0;

		count = 0;

		traversal(nums, 0, S);

		return count;
	}

	private void traversal(int [] nums, int i, int target)
	{
		if(i == nums.length && target == 0)
		{
			count++;
			return;
		}

		if(i == nums.length)
			return;
		else
		{
			traversal(nums, i + 1, target - nums[i]);
			traversal(nums, i + 1, target + nums[i]);
		}
	}
}

// Solution Two
public class Solution
{
	public int findTargetSumWays(int [] nums, int S)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int sum = 0;

		for(int x: nums)
			sum += x;

		if(s > sum || s < -sum)
			return 0;

		int [] dp = new int [sum * 2 + 1];
		dp[sum] = 1;

		for(int i = 0;i < nums.length;i++)
		{
			int [] next = new int [sum * 2 + 1];

			for(int j = 0;j < sum * 2 + 1;j++)
			{
				if(dp[j]!= 0)
				{
					next[j + nums[i]] += dp[j];
					next[j - nums[i]] += dp[j];
				}
			}

			dp = next;
		}

		return dp[sum + s];
	}
}