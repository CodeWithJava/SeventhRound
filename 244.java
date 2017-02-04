public class WordDistance
{
	Map<String, List<Integer>> map;

	public WordDistance(String [] words)
	{
		if(words == null || words.length == 0)
			return;

		map = new HashMap<>();

		for(int i = 0;i < words.length;i++)
		{
			if(!map.containsKey(words[i]))
				map.put(words[i], new ArrayList<>());

			map.get(words[i]).add(i);
		}
	}

	public int shortest(String word1, String word2)
	{
		int min = Integer.MAX_VALUE;

		List<Integer> m = map.get(word1);
		List<Integer> n = map.get(word2);

		for(int x: m)
			for(int y: n)
				min = Math.min(min, Math.abs(x - y));

		return min;
	}
}