public class Solution
{
	public int firstMissingPositive(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 1;

		for(int i = 0;i < nums.length;i++)
		{
			while(nums[i] != i + 1)
			{
				if(nums[i] <= 0 || nums[i] >= nums.length)
					break;

				if(nums[nums[i] - 1] == nums[i])
					break;

				int t = nums[i];
				nums[i] = nums[t - 1];
				nums[t - 1] = t;
			}
		}

		for(int i = 0;i < nums.length;i++)
			if(nums[i] != i + 1)
				return ++i;

		return nums.length + 1;
	}
}