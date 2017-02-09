public class ValidWordAbbr
{
	Map<String, Set<String>> map;

	ValidWordAbbr(String [] dictionary)
	{
		map = new HashMap<>();

		if(dictionary == null || dictionary.length == 0)
			return;

		for(String x: dictionary)
		{
			String s = x;

			if(s.length() > 2)
				s = s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);

			if(!map.containsKey(s))
				map.put(s, new HashSet<>());

			map.get(s).add(x);
		}
	}

	public boolean isUnique(String word)
	{
		if(word == null)
			return false;

		String s = word;

		if(s.length() > 2)
			s = s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);

		if(!map.containsKey(s))
			return true;
		else
			return map.get(s).contains(word) && map.get(s).size() == 1;
	}
}