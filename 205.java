public class Solution
{
	public boolean isIsomorphic(String s, String t)
	{
		if((s == null || s.length() == 0) && (t == null || t.length() == 0))
			return true;

		if((s == null || s.length() == 0) || (t == null || t.length() == 0))
			return false;

		if(s.length() != t.length())
			return false;

		Map<Character, Character> map = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);
			char y = t.charAt(i);

			if(map.containsKey(x))
			{
				if(map.get(x) != y)
					return false;
			}
			else if(map.containsValue(y))
				return false;
			else
				map.put(x, y);
		}

		return true;
	}
}