public class Solution
{
	public int lengthOfLongestSubstring(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		int start = 0;
		int max = 0;

		Set<Character> set = new HashSet<>();

		for(char x: s.toCharArray())
		{
			if(set.contains(x))
			{
				max = Math.max(max, set.size());

				while(set.contains(x))
					set.remove(s.charAt(start++));
			}

			set.add(x);
		}

		return Math.max(max, set.size());
	}
}