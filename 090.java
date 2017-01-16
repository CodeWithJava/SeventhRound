public class Solution
{
	public List<List<Integer>> subsetsWithDup(int [] nums)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		Arrays.sort(nums);

		Set<List<Integer>> set = new HashSet<>();

		for(int x: nums)
		{
			List<List<Integer>> t = new ArrayList<>();

			for(List<Integer> p: set)
				t.add(new ArrayList<>(p));

			for(List<Integer> p: t)
				p.add(x);

			List<Integer> itself = new ArrayList<>();
			itself.add(x);
			t.add(itself);

			set.addAll(t);
		}

		set.add(new ArrayList<>());

		result.addAll(set);

		return result;
	}
}