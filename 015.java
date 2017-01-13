public class Solution
{
	public List<List<Integer>> threeSum(int [] nums)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);

		for(int i = 0;i < nums.length - 2;i++)
		{
			if(i == 0 || nums[i - 1] < nums[i])
			{
				int j = i + 1;
				int k = nums.length - 1;

				while(j < k)
				{
					int sum = nums[i] + nums[j] + nums[k];

					if(sum == 0)
					{
						List<Integer> t = new ArrayList<>();
						t.add(nums[i]);
						t.add(nums[j]);
						t.add(nums[k]);

						result.add(new ArrayList<>(t));

						j++;
						k--;

						while(j < k && nums[j] == nums[j - 1])	j++;
						while(j < k && nums[k] == nums[k + 1])	k--;
					}
					else if(sum < 0)
						j++;
					else
						k--;
				}
			}
		}

		return result;
	}
}