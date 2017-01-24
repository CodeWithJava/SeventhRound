public class Solution
{
	public List<Integer> majorityElement(int [] nums)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		Integer n1 = null;
		Integer n2 = null;

		int c1 = 0;
		int c2 = 0;

		for(int x: nums)
		{
			if(n1 != null && n1.intValue() == x)
				c1++;
			else if(n2 != null && n2.intValue() == x)
				c2++;
			else if(c1 == 0)
			{
				n1 = x;
				c1++;
			}
			else if(c2 == 0)
			{
				n2 = x;
				c2++;
			}
			else
			{
				c1--;
				c2--;
			}
		}

		c1 = 0;
		c2 = 0;

		for(int x: nums)
		{
			if(n1.intValue() == x)
				c1++;
			else if(n2.intValue() == x)
				c2++;
		}

		if(c1 > nums.length / 3)
			result.add(n1);

		if(c2 > nums.length / 3)
			result.add(n2);

		return result;
	}
}