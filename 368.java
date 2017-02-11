public class Solution
{
	public List<Integer> largestDivisibleSubset(int [] nums)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		Arrays.sort(nums);

		int [] dp = new int [nums.length];
		Arrays.fill(dp, 1);

		int [] index = new int [nums.length];
		Arrays.fill(index, -1);

		int maxDP = 1;
		int maxIdx = 0;

		for(int i = 0;i < nums.length;i++)
		{
			for(int j = i - 1;j >= 0;j--)
			{
				if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i])
				{
					dp[i] = dp[j] + 1;
					index[i] = j;
				}
			}

			if(maxDP < dp[i])
			{
				maxDP = dp[i];
				maxIdx = i;
			}
		}

		for(int i = maxIdx;i != -1;i = index[i])
			result.add(nums[i]);

		return result;
	}
}