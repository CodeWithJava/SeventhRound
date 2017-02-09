public class Solution
{
	public boolean PredictTheWinner(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return true;

		return select(nums, 0, nums.length - 1) >= 0;
	}

	private int select(int [] nums, int l, int r)
	{
		return l == r ? nums[l]:Math.max(nums[l] - select(nums, l + 1, r), nums[r] - select(nums, l, r - 1));
	}
}