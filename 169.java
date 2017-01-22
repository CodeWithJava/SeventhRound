public class Solution
{
	public int majorityElement(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;
		int count = 0;

		for(int x: nums)
		{
			if(count == 0)
			{
				result = x;
				count = 1;
			}
			else if(result == x)
				count++;
			else
				count--;
		}

		return result;
	}
}