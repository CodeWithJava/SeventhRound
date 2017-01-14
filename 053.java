public class Solution
{
	public int maxSubArray(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int globalMax = nums[0];
		int localMax = nums[0];

		for(int i = 1;i < nums.length;i++)
		{
			localMax = Math.max(localMax + nums[i], nums[i]);
			globalMax = Math.max(globalMax, localMax);
		}

		return globalMax;
	}
}