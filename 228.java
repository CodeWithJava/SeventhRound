public class Solution
{
	public List<String> summaryRanges(int [] nums)
	{
		List<String> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		if(nums.length == 1)
		{
			result.add(String.valueOf(nums[0]));
			return result;
		}

		int first = nums[0];
		int prev = nums[0];

		for(int i = 1;i < nums.length;i++)
		{
			if(prev + 1 == nums[i])
			{
				if(i == nums.length - 1)
					result.add(first + "->" + nums[i]);
			}
			else
			{
				if(first == prev)
					result.add(String.valueOf(first));
				else
					result.add(first + "->" + prev);

				if(i == nums.length - 1)
					result.add(String.valueOf(nums[i]));

				first = nums[i];
			}

			prev = nums[i];
		}

		return result;
	}
}