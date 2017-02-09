public class Solution
{
	public boolean canConstruct(String ransomNote, String magazine)
	{
		if(magazine == null)
			return false;

		if(ransomNote == null)
			return true;

		int [] ascii = new int [256];

		for(char x: magazine.toCharArray())
			ascii[x - 'a']++;

		for(char x: ransomNote.toCharArray())
			if(-- ascii[x - 'a'] < 0)
				return false;

		return true;
	}
}