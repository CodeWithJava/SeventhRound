public class Solution
{
	public boolean increasingTriplet(int [] nums)
	{
		if(nums == null || nums.length < 3)
			return false;

		int x1 = Integer.MAX_VALUE;
		int x2 = Integer.MAX_VALUE;

		for(int x: nums)
		{
			if(x <= x1)
				x1 = x;
			else if(x <= x2)
				x2 = x;
			else
				return true;
		}

		return false;
	}
}