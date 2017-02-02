// Solution One
public class Solution
{
	public int lengthOfLIS(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int [] dp = new int [nums.length];
		int max = 1;

		for(int i = 0;i < nums.length;i++)
		{
			dp[i] = 1;

			for(int j = 0;j < i;j++)
				if(nums[j] < nums[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);

			max = Math.max(max, dp[i]);
		}

		return max;
	}
}

// Solution two
public class Solution
{
	public int lengthOfLIS(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		List<Integer> list = new ArrayList<>();

		for(int x: nums)
		{
			if(list.isEmpty() || list.get(list.size() - 1) < x)
				list.add(x);
			else
			{
				int l = 0;
				int r = list.size() - 1;

				while(l < r)
				{
					int m = l + (r - l) / 2;

					if(list.get(m) < x)
						l = m + 1;
					else
						r = m;
				}

				list.set(r, x);
			}
		}

		return list.size();
	}
}