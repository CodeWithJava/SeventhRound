public class Solution
{
	public List<Integer> findSubstring(String s, String [] words)
	{
		List<Integer> result = new ArrayList<>();

		if(s == null || s.length() == 0 || words == null || words.length == 0)
			return result;

		Map<String, Integer> map = new HashMap<>();

		for(String word: words)
		{
			if(map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}

		int l = words[0].length();

		for(int i = 0;i < l;i++)
		{
			Map<String, Integer> curr = new HashMap<>();

			int start = i;
			int count = 0;

			for(int j = i;j <= s.length() - l;j += l)
			{
				String sub = s.substring(j, j + l);

				if(map.containsKey(sub))
				{
					if(curr.containsKey(sub))
						curr.put(sub, curr.get(sub) + 1);
					else
						curr.put(sub, 1);

					count++;

					while(curr.get(sub) > map.get(sub))
					{
						String left = s.substring(start, start + l);

						curr.put(left, curr.get(left) - 1);

						start += l;
						count--;
					}

					if(count == words.length)
					{
						result.add(start);

						String left = s.substring(start, start + l);

						curr.put(left, curr.get(left) - 1);

						start += l;
						count--;
					}
				}
				else
				{
					curr.clear();

					start = j + l;
					count = 0;
				}
			}
		}

		return result;
	}
}