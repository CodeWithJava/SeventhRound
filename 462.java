public class Solution
{
	public int minMoves2(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		Arrays.sort(nums);

		int l = 0;
		int r = nums.length - 1;
		int moves = 0;

		while(l < r)
			moves += nums[r--] - nums[l++];

		return moves;
	}
}