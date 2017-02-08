public class Solution
{
	public boolean containsNearbyDuplicate(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 0)
			return false;

		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0;i < nums.length;i++)
		{
			if(map.containsKey(nums[i]))
				min = Math.min(min, i - map.get(nums[i]));

			map.put(nums[i], i);
		}

		return min <= k;
	}
}