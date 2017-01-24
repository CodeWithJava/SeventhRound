public class Solution
{
	public boolean isAnagram(String s, String t)
	{
		if((s == null || s.length() == 0) && (t == null || t.length() == 0))
			return true;

		if((s == null || s.length() == 0) || (t == null || t.length() == 0))
			return false;

		if(s.length() != t.length())
			return false;

		int [] alphabets = new int [26];

		for(char x: s.toCharArray())
			alphabets[x - 'a']++;

		for(char x: t.toCharArray())
			if(-- alphabets[x - 'a'] < 0)
				return false;

		return true;
	}
}