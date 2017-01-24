public class Solution
{
	public List<List<Integer>> getFactors(int n)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(n < 2)
			return result;

		List<Integer> t = new ArrayList<>();

		traversal(n, 2, t, result);

		return result;
	}

	private void traversal(int n, int start, List<Integer> t, List<List<Integer>> result)
	{
		if(n == 1 && t.size() > 1)
			result.add(new ArrayList<>(t));
		else
		{
			for(int i = start;i <= n;i++)
			{
				if(n % i == 0)
				{
					t.add(i);
					traversal(n / i, i, t, result);
					t.remove(t.size() - 1);
				}
			}
		}
	}
}