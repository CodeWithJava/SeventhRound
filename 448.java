public class Solution
{
	public List<Integer> findDisappearedNumbers(int [] nums)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		for(int x: nums)			
		{
			int idx = Math.abs(x) - 1;

			if(nums[idx] > 0)
				nums[idx] = -nums[idx];
		}

		for(int i = 0;i < nums.length;i++)
			if(nums[i] > 0)
				result.add(i + 1);

		return result;
	}
}