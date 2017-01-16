public class Solution
{
	public List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(n < 0 || k < 0)
			return result;

		List<Integer> t = new ArrayList<>();

		traversal(n, 1, k, t, result);

		return result;
	}

	private void traversal(int n, int start, int k, List<Integer> t, List<List<Integer>> result)
	{
		if(t.size() == k)
			result.add(new ArrayList<>(t));
		else
		{
			for(int i = start;i <= n;i++)
			{
				t.add(i);
				traversal(n, i + 1, k, t, result);
				t.remove(t.size() - 1);
			}
		}
	}
}