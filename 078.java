public class Solution
{
	public List<List<Integer>> subsets(int [] nums)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
		{
			result.add(new ArrayList<>());
			return result;
		}

		for(int x: nums)
		{
			List<List<Integer>> t = new ArrayList<>();

			for(List<Integer> p: result)
				t.add(new ArrayList<>(p));

			for(List<Integer> p: result)
				p.add(x);

			List<Integer> itself = new ArrayList<>();
			itself.add(x);
			t.add(new ArrayList<>(itself));

			result.addAll(t);
		}

		result.add(new ArrayList<>());

		return result;
	}
}