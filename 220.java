public class Solution
{
	public boolean containsNearbyAlmostDuplicate(int [] nums, int k, int t)
	{
		if(nums == null || nums.length == 0 || k < 1 || t < 0)
			return false;

		TreeSet<Long> set = new TreeSet<>();

		for(int i = 0;i < nums.length;i++)
		{
			long curr = nums[i];

			if(set.floor(curr) != null && set.floor(curr) + t >= curr)
				return true;

			if(set.ceiling(curr) != null && set.ceiling(curr) - t <= curr)
				return true;

			set.add(curr);

			if(set.size() > k)
				set.remove((long)nums[i - k]);
		}

		return false;
	}
}