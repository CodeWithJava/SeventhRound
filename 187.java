public class Solution
{
	public List<String> findRepeatedDnaSequences(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() < 10)
			return result;

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		Map<Integer, Integer> records = new HashMap<>();

		int hash = 0;

		for(int i = 0;i < s.length();i++)
		{
			hash <<= 2;
			hash += map.get(s.charAt(i));

			if(i >= 9)
			{
				hash &= (1 << 20) - 1;

				if(records.containsKey(hash))
				{
					if(records.get(hash) == 1)
					{
						result.add(s.substring(i - 9, i + 1));
						records.put(hash, 2);
					}
				}
				else
					records.put(hash, 1);
			}
		}

		return result;
	}
}