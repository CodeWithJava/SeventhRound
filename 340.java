public class Solution
{
	public int lengthOfLongestSubstringKDistinct(String s, int k)
	{
		if(s == null || s.length() == 0 || k < 0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();

		int max = 0;
		int start = 0;

		for(int i = 0;i < s.length();i++)
		{
			char c = s.charAt(i);

			if(map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
			{
				map.put(c, 1);

				while(map.size() > k)
				{
					char x = s.charAt(start++);

					int count = map.get(x);

					if(count > 1)
						map.put(x, count - 1);
					else
						map.remove(x);
				}
			}

			max = Math.max(max, i - start + 1);
		}

		return max;
	}
}