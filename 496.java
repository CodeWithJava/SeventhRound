public class Solution
{
	public int [] nextGreaterElement(int [] findNums, int [] nums)
	{
		if(findNums == null || findNums.length == 0 || nums == null || nums.length == 0 || findNums.length > nums.length)
			return new int [0];

		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0;i < nums.length;i++)
			map.put(nums[i], i);

		int [] result = new int [findNums.length];
		Arrays.fill(result, -1);

		for(int i = 0;i < findNums.length;i++)
		{
			if(map.get(findNums[i]) + 1 == nums.length)
				continue;

			for(int j = map.get(findNums[i]) + 1;j < nums.length;j++)
			{
				if(nums[j] > findNums[i])
				{
					result[i] = nums[j];
					break;
				}
			}
		}

		return result;
	}
}