public class Solution
{
	public List<Integer> findAnagrams(String s, String p)
	{
		List<Integer> result = new ArrayList<>();

		if(s == null || s.length() == 0 || p == null || p.length() == 0)
			return result;

		int [] alphabets = new int [26];

		for(char c: p.toCharArray())
			alphabets[c - 'a']++;

		int l = 0;
		int r = 0;
		int count = p.length();

		while(r < s.length())
		{
			if(alphabets[s.charAt(r++) - 'a']-- > 0)
				count--;

			if(count == 0)
				result.add(l);

			if(r - l == p.length() && alphabets[s.charAt(l++) - 'a']++ >= 0)
				count++;
		}

		return result;
	}
}