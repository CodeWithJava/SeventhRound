public class Solution
{
	public int strobogrammaticInRange(String low, String high)
	{
		if(low == null || low.length() == 0 || high == null || high.length() == 0 || Long.valueOf(low) > Long.valueOf(high))
			return 0;

		int m = low.length();
		int n = high.length();

		List<String> candidates = new ArrayList<>();

		for(int i = m;i <= n;i++)
			candidates.addAll(findStrobogrammatic(i));

		int count = candidates.size();

		int i = 0;

		while(i < candidates.size() && candidates.get(i).length() == m)
		{
			if(low.compareTo(candidates.get(i)) > 0)
				count--;

			i++;
		}

		i = candidates.size() - 1;

		while(i >= 0 && candidates.get(i).length() == n)
		{
			if(high.compareTo(candidates.get(i)) < 0)
				count--;

			i--;
		}

		return count;
	}

	private static final char [] key = {'0', '1', '6', '8', '9'};
	private static final char [] val = {'0', '1', '9', '8', '6'};

	private List<String> findStrobogrammatic(int n)
	{
		List<String> result = new ArrayList<>();

		if(n < 1)
			return result;

		char [] t = new char [n];

		traversal(n, 0, t, result);

		return result;
	}

	private void traversal(int n, int idx, char [] t, List<String> result)
	{
		if(idx > n / 2 || idx == n / 2 && n % 2 == 0)
			result.add(new String(t));
		else
		{
			for(int i = 0;i < key.length;i++)
			{
				if(idx == 0 && key[i] == '0' && n > 1 || idx == n - 1 - idx && (key[i] == '6' || key[i] == '9'))
					continue;

				t[idx] = key[i];
				t[n - 1 - idx] = val[i];

				traversal(n, idx + 1, t, result);
			}
		}
	}
}