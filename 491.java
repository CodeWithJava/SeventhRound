public class Solution
{
	Set<List<Integer>> set;

	public List<List<Integer>> findSubsequences(int [] nums)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

        set = new HashSet<>();

		List<Integer> holder = new ArrayList<>();

		traversal(holder, 0, nums);

		result.addAll(set);

		return result;
	}

	private void traversal(List<Integer> holder, int idx, int [] nums)
	{
		if(holder.size() > 1)
			set.add(new ArrayList<>(holder));

		for(int i = idx;i < nums.length;i++)
		{
			if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i])
			{
				holder.add(nums[i]);
				traversal(holder, i + 1, nums);
				holder.remove(holder.size() - 1);
			}
		}
	}
}