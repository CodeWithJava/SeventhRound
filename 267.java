public class Solution
{
	public List<String> generatePalindromes(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0)
			return result;

		Map<Character, Integer> map = new HashMap<>();

		for(char x: s.toCharArray())
		{
			if(map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put(x, 1);
		}

		boolean ready = false;

		String candidates = "";
		String single = "";

		for(char x: map.keySet())
		{
			int half = map.get(x) / 2;

			for(int i = 0;i < half;i++)
				candidates += x;

			if(map.get(x) % 2 != 0)
			{
				if(ready)
					return result;
				else
				{
					ready = true;
					single += x;
				}
			}
		}

		permutation(candidates, single, candidates.length(), "", result);

		return result;
	}

	private void permutation(String candidates, String single, int l, String left, List<String> result)
	{
		if(left.length() == l)
			result.add(left + single + new StringBuilder(left).reverse().toString());
		else
		{
			for(int i = 0;i < candidates.length();i++)
			{
				if(i != 0 && candidates.charAt(i - 1) == candidates.charAt(i))
					continue;

				permutation(candidates.substring(0, i) + candidates.substring(i + 1), single, l, left + candidates.charAt(i), result);
			}
		}
	}
}