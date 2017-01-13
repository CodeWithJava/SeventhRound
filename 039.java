public class Solution
{
	public List<List<Integer>> combinationSum(int [] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(candidates == null || candidates.length == 0)
			return result;

		Arrays.sort(candidates);

		List<Integer> t = new ArrayList<>();

		traversal(candidates, 0, target, t, result);

		return result;
	}

	private void traversal(int [] candidates, int start, int target, List<Integer> t, List<List<Integer>> result)
	{
		if(target == 0)
			result.add(new ArrayList<>(t));
		else
		{
			for(int i = start;i < candidates.length;i++)
			{
				if(target < candidates[i])
					return;

				t.add(candidates[i]);
				traversal(candidates, i, target - candidates[i], t, result);
				t.remove(t.size() - 1);
			}
		}
	}
}