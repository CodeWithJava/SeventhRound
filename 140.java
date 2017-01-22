public class Solution
{
	Map<String, List<String>> map = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return result;

		if(map.get(s) != null)
			return map.get(s);

		if(wordDict.contains(s))
			result.add(s);

		for(int i = 1;i <= s.length();i++)
		{
			String sub = s.substring(0, i);

			if(wordDict.contains(sub))
			{
				List<String> x = wordBreak(s.substring(i), wordDict);

				for(String str: x)
					result.add(sub + " " + str);
			}
		}

		map.put(s, result);

		return result;
	}
}