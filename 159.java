public class Solution
{
	public int lengthOfLongestSubstringTwoDistinct(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		int max = 0;
		int start = 0;

		Map<Character, Integer> map = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(map.size() == 2 && !map.containsKey(x))
			{
				char left = ' ';
				int min = s.length();

				for(char c: map.keySet())
				{
					int last = map.get(c);

					if(last < min)
					{
						min = last;
						left = c;
					}
				}

				map.remove(left);
				start = min + 1;
			}

			map.put(x, i);

			max = Math.max(max, i - start + 1);
		}

		return max;
	}
}