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