public class Solution
{
	public int minMoves(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int min = nums[0];

		for(int x: nums)
			min = Math.min(min, x);

		int result = 0;

		for(int x: nums)
			result += x - min;

		return result;
	}
}