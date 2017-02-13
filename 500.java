public class Solution
{
	private static final String [] strs = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

	public String [] findWords(String [] words)
	{
		if(words == null || words.length == 0)
			return new String [0];

		Map<Character, Integer> map = new HashMap<>();

		for(int i = 0;i < strs.length;i++)
			for(char x: strs[i].toCharArray())
				map.put(x, i);

		List<String> t = new ArrayList<>();

		for(String word: words)
		{
			if(word.equals(""))
				continue;

			int idx = map.get(word.toLowerCase().charAt(0));

			for(char x: word.toLowerCase().toCharArray())
			{
				if(map.get(x) != idx)
				{
					idx = -1;
					break;
				}
			}

			if(idx != -1)
				t.add(word);
		}

		return t.toArray(new String [0]);
	}
}