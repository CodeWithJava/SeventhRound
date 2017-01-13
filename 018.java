public class Solution
{
	public List<List<Integer>> fourSum(int [] nums, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(nums == null || nums.length < 4)
			return result;

		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<>();

		for(int i = 0;i < nums.length - 3;i++)
		{
			for(int j = i + 1;j < nums.length - 2;j++)
			{
				int k = j + 1;
				int l = nums.length - 1;

				while(k < l)
				{
					int sum = nums[i] + nums[j] + nums[k] + nums[l];

					if(sum == target)
					{
						List<Integer> t = new ArrayList<>();

						t.add(nums[i]);
						t.add(nums[j]);
						t.add(nums[k]);
						t.add(nums[l]);

						if(!set.contains(t))
						{
							result.add(new ArrayList<>(t));
							set.add(new ArrayList<>(t));
						}

						k++;
						l--;
					}
					else if(sum < target)
						k++;
					else
						l--;
				}
			}
		}

		return result;
	}
}