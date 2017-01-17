public class Solution
{
	public int singleNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;

		for(int x: nums)
			result ^= x;

		return result;
	}
}