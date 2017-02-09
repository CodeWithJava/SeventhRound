public class Solution
{
	public int minPatches(int [] nums, int n)
	{
		if(nums == null || n < 1)
			return -1;

		long currReach = 1;
		int count = 0;
		int i = 0;

		while(currReach <= n)
		{
			if(i < nums.length && nums[i] <= currReach)
			{
				currReach += nums[i];
				i++;
			}
			else
			{
				currReach <<= 1;
				count++;
			}
		}

		return count;
	}
}