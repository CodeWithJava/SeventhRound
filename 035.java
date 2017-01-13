public class Solution
{
	public int searchInsert(int [] nums, int target)
	{
		if(nums == null || nums.length == 0)
			return 0;

		if(target <= nums[0])
			return 0;

		for(int i = 1;i < nums.length;i++)
			if(nums[i - 1] < target && target <= nums[i])
				return i;

		return nums.length;
	}
}