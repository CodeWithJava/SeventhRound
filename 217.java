public class Solution
{
	public boolean containsDuplicate(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return false;

		Set<Integer> set = new HashSet<>();

		for(int x: nums)
		{
			if(set.contains(x))
				return true;
			set.add(x);
		}

		return false;
	}
}