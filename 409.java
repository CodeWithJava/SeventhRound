public class Solution
{
	public int longestPalindrome(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		int count = 0;

		Set<Character> set = new HashSet<>();

		for(char x: s.toCharArray())
		{
			if(set.contains(x))
			{
				count++;
				set.remove(x);
			}
			else
				set.add(x);
		}

		return set.size() != 0 ? count * 2 + 1:count * 2;
	}
}