public class Solution
{
	public List<List<Integer>> permuteUnique(int [] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		if(nums == null || nums.length == 0)
			return result;

		for(int x: nums)
		{
			Set<List<Integer>> t = new HashSet<>();

			for(List<Integer> p: result)
			{
				for(int i = 0;i <= p.size();i++)
				{
					p.add(i, x);
					t.add(new ArrayList<>(p));
					p.remove(i);
				}
			}

			result.clear();
			result.addAll(t);
		}

		return result;
	}
}