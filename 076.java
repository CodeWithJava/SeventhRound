public class Solution
{
	public String minWindow(String s, String t)
	{
		if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length())
			return "";

		Map<Character, Integer> target = new HashMap<>();

		for(char x: t.toCharArray())
		{
			if(target.containsKey(x))
				target.put(x, target.get(x) + 1);
			else
				target.put(x, 1);
		}

		Map<Character, Integer> source = new HashMap<>();

		int l = 0;
		int count = 0;
		int min = s.length() + 1;
		String result = "";

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(target.containsKey(x))
			{
				if(source.containsKey(x))
				{
					if(source.get(x) < target.get(x))
						count++;

					source.put(x, source.get(x) + 1);
				}
				else
				{
					count++;
					source.put(x, 1);
				}
			}

			if(count == t.length())
			{
				char c = s.charAt(l);

				while(!source.containsKey(c) || source.get(c) > target.get(c))
				{
					if(source.containsKey(c) && source.get(c) > target.get(c))
						source.put(c, source.get(c) - 1);

					c = s.charAt(++l);
				}

				if(i - l + 1 < min)
				{
					min = i - l + 1;
					result = s.substring(l, i + 1);
				}
			}
		}

		return result;
	}
}