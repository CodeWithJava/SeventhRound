public class Solution
{
	public List<List<Integer>> combinationSum2(int [] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(candidates == null || candidates.length == 0)
			return result;

		Arrays.sort(candidates);

		Set<List<Integer>> set = new HashSet<>();

		List<Integer> t = new ArrayList<>();

		traversal(candidates, 0, target, t, set);

		result.addAll(set);

		return result;
	}

	private void traversal(int [] candidates, int start, int target, List<Integer> t, Set<List<Integer>> set)
	{
		if(target == 0)
			set.add(new ArrayList<>(t));
		else
		{
			for(int i = start;i < candidates.length;i++)
			{
				if(target < candidates[i])
					return;

				t.add(candidates[i]);
				traversal(candidates, i + 1, target - candidates[i], t, set);
				t.remove(t.size() - 1);
			}
		}
	}
}