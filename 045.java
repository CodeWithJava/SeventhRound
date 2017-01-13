public class Solution
{
	public int jump(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return 0;

		int curr = 0;
		int max = 0;
		int step = 0;

		for(int i = 0;i <= max && i < nums.length;i++)
		{
			if(curr < i)
			{
				curr = max;
				step++;
			}

			if(max < i + nums[i])
				max = i + nums[i];
		}

		if(max < nums.length - 1)
			return -1;

		return step;
	}
}