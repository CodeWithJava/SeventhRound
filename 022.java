public class Solution
{
	public List<String> generateParenthesis(int n)
	{
		List<String> result = new ArrayList<>();

		if(n < 1)
			return result;

		traversal(n, n, "", result);

		return result;
	}

	private void traversal(int l, int r, String t, List<String> result)
	{
		if(l > r)
			return;

		if(l == 0 && r == 0)
			result.add(t);
		else
		{
			if(l > 0)
				traversal(l - 1, r, t + "(", result);

			if(r > 0)
				traversal(l, r - 1, t + ")", result);
		}
	}
}