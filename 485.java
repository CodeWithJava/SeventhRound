public class Solution
{
	public int findMaxConsecutiveOnes(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int count = 0;
		int max = 0;

		for(int x: nums)
		{
			if((x & 1) == 1)
				count++;
			else
			{
				max = Math.max(max, count);
				count = 0;
			}
		}

		return Math.max(max, count);
	}
}