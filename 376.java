public class Solution
{
	public int wiggleMaxLength(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int max = 1;
		int j = 0;

		for(int i = 0;i < nums.length;i++)
		{
			if(nums[j] < nums[i])
			{
				max++;

				while(i < nums.length - 1 && nums[i] <= nums[i + 1])	i++;
			}
			else if(nums[j] > nums[i])
			{
				max++;

				while(i < nums.length - 1 && nums[i] >= nums[i + 1])	i++;
			}

			j = i;
		}

		return max;
	}
}