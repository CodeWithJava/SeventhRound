public class Solution
{
	public String getPermutation(int n, int k)
	{
		if(n < 0 || k < 0)
			return "";

		int fatorial = 1;
		List<Integer> t = new ArrayList<>();

		for(int i = 1;i <= n;i++)
		{
			fatorial *= i;
			t.add(i);
		}

		k--;

		StringBuilder sb = new StringBuilder();

		for(int i = 0;i < n;i++)
		{
			fatorial /= n - i;

			int idx = k / fatorial;
			k %= fatorial;

			sb.append(t.get(idx));
			t.remove(idx);
		}

		return sb.toString();
	}
}