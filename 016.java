public class Solution
{
	public int threeSumClosest(int [] nums, int target)
	{
		if(nums == null || nums.length < 3)
			throw new IllegalArgumentException("Input is invalid");

		Arrays.sort(nums);

		int delta = Integer.MAX_VALUE;
		int result = 0;

		for(int i = 0;i < nums.length - 2;i++)
		{
			int j = i + 1;
			int k = nums.length - 1;

			while(j < k)
			{
				int sum = nums[i] + nums[j] + nums[k];

				int d = Math.abs(sum - target);

				if(d == 0)
					return sum;

				if(d < delta)
				{
					result = sum;
					delta = d;
				}

				if(sum < target)
					j++;
				else
					k--;
			}
		}

		return result;
	}
}