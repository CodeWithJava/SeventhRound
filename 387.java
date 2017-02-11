public class Solution
{
	public int firstUniqChar(String s)
	{
		if(s == null || s.length() == 0)
			return -1;

		Map<Character, List<Integer>> map = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char c = s.charAt(i);

			if(!map.containsKey(c))
				map.put(c, new ArrayList<>());

			map.get(c).add(i);
		}

		int min = s.length();

		for(char c: map.keySet())
			if(map.get(c).size() == 1)
				min = Math.min(min, map.get(c).get(0));

		return min == s.length() ? -1:min;
	}
}