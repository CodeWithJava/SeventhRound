public class Solution
{
	public List<String> findMissingRanges(int [] nums, int lower, int upper)
	{
		List<String> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
		{
			if(lower == upper)
				result.add(String.valueOf(lower));
			else if(lower < upper)
				result.add(lower + "->" + upper);

			return result;
		}

		for(int i = 0;i <= nums.length;i++)
		{
			if(i == 0)
			{
				if((long)lower + 1 == (long)nums[i])
					result.add(String.valueOf(lower));
				else if((long)lower + 1 < nums[i])
					result.add(lower + "->" + (nums[i] - 1));
			}
			else if(i == nums.length)
			{
				if((long)nums[i - 1] + 1 == (long)upper)
					result.add(String.valueOf(upper));
				else if((long)nums[i - 1] + 1 < (long)upper)
					result.add((long)nums[i - 1] + 1 + "->" + upper);
			}
			else
			{
				if((long)nums[i - 1] + 2 == (long)nums[i])
					result.add(String.valueOf((long)nums[i - 1] + 1));
				else if((long)nums[i - 1] + 2 < (long)nums[i]) 
					result.add((long)nums[i - 1] + 1 + "->" + (nums[i] - 1));
			}
		}

		return result;
	}
}