public class Solution
{
	public List<List<Integer>> combinationSum3(int k, int n)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(k < 0 || n < 1)
			return result;

		List<Integer> t = new ArrayList<>();

		traversal(n, k, 1, t, result);

		return result;
	}

	private void traversal(int n, int k, int start, List<Integer> t, List<List<Integer>> result)
	{
		if(n == 0 && t.size() == k)
			result.add(new ArrayList<>(t));
		else
		{
			for(int i = start;i <= 9;i++)
			{
				if(n < i)
					return;

				t.add(i);
				traversal(n - i, k, i + 1, t, result);
				t.remove(t.size() - 1);
			}
		}
	}
}