public class Solution
{
	public int findPairs(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 0)	
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;

		for(int x: nums)
			map.put(x, map.getOrDefault(x, 0) + 1);

		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			if(k == 0)
			{
				if(entry.getValue() > 1)
					result++;
			}
			else
			{
				if(map.containsKey(entry.getKey() + k))
					result++;
			}
		}

		return result;
	}
}