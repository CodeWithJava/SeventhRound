public class Solution
{
	public List<List<String>> groupAnagrams(String [] strs)
	{
		List<List<String>> result = new ArrayList<>();

		if(strs == null || strs.length == 0)
			return result;

		Map<String, List<String>> map = new HashMap<>();

		for(String str: strs)
		{
			char [] x = str.toCharArray();
			Arrays.sort(x);
			String s = new String(x);

			if(!map.containsKey(s))
				map.put(s, new ArrayList<>());

			map.get(s).add(str);
		}

		result.addAll(map.values());

		return result;
	}
}