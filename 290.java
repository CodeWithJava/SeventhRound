public class Solution
{
	public boolean wordPattern(String pattern, String str)
	{
		if((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0))
			return true;

		if((pattern == null || pattern.length() == 0) || (str == null || str.length() == 0))
			return false;

		String [] strs = str.split(" ");

		if(pattern.length() != strs.length)
			return false;

		Map<Character, String> map = new HashMap<>();

		for(int i = 0;i < pattern.length();i++)
		{
			char x = pattern.charAt(i);

			if(map.containsKey(x))
			{
				if(!map.get(x).equals(strs[i]))
					return false;
			}
			else if(map.containsValue(strs[i]))
				return false;
			else
				map.put(x, strs[i]);
		}

		return true;
	}
}