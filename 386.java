public class Solution
{
	public List<Integer> lexicalOrder(int n)
	{
		List<Integer> result = new ArrayList<>();

		if(n < 1)
			return result;

		for(int i = 1;i <= 9;i++)
			traversal(i, n, result);

		return result;
	}

	private void traversal(int curr, int n, List<Integer> result)
	{
		if(curr > n)
			return;

		result.add(curr);

		for(int i = 0;i <= 9;i++)
		{
			if(curr * 10 + i > n)
				return;

			traversal(curr * 10 + i, n, result);
		}
	}
}