// Solution One
public class Solution
{
	public char findTheDifference(String s, String t)
	{
		int x = 0;

		for(char c: s.toCharArray())
			x ^= c;

		for(char c: t.toCharArray())
			x ^= c;

		return (char)x;
	}
}
// Solution Two
public class Solution
{
	public char findTheDifference(String s, String t)
	{
		int [] alphabets = new int [26];

		for(char x: s.toCharArray())
			alphabets[x - 'a']++;

		for(char x: t.toCharArray())
			alphabets[x - 'a']--;

		int x = 0;

		for(int i = 0;i < alphabets.length;i++)
		{
			if(alphabets[i] != 0)
			{
				x = i;
				break;
			}
		}

		return (char)(x + 'a');
	}
}