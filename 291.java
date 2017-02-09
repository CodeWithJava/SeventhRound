public class Solution
{
	Set<String> set;
	Map<Character, String> map;
	boolean result;

	public boolean wordPatternMatch(String pattern, String str)
	{
		if((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0))
			return true;

		if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0)
			return false;

        set = new HashSet<>();
        map = new HashMap<>();

		traversal(pattern, str, 0, 0);

		return result;
	}

	private void traversal(String pattern, String str, int i, int j)
	{
		if(i == pattern.length() && j == str.length())
			result = true;
		else
		{
			if(i >= pattern.length() || j >= str.length())
				return;

			char c = pattern.charAt(i);

			for(int cut = j + 1;cut <= str.length();cut++)
			{
				String sub = str.substring(j, cut);

				if(!set.contains(sub) && !map.containsKey(c))
				{
					set.add(sub);
					map.put(c, sub);

					traversal(pattern, str, i + 1, cut);

					set.remove(sub);
					map.remove(c);
				}
				else if(map.containsKey(c) && map.get(c).equals(sub))
					traversal(pattern, str, i + 1, cut);
			}
		}
	}
}