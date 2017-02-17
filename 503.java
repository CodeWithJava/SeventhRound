public class Solution
{
	public int [] nextGreaterElements(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return new int [0];

		int [] reservoir = new int [nums.length * 2];

		for(int i = 0;i < nums.length;i++)
			reservoir[i] = nums[i];

		for(int i = 0;i < nums.length;i++)
			reservoir[nums.length + i] = nums[i];

		int [] result = new int [nums.length];
		Arrays.fill(result, -1);

		for(int i = 0;i < nums.length;i++)
		{
			for(int j = i + 1;j < reservoir.length;j++)
			{
				if(reservoir[j] > nums[i])
				{
					result[i] = reservoir[j];
					break;
				}
			}
		}

		return result;
	}
}