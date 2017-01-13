public class Solution
{
	public boolean isMatch(String s, String p)
	{
		int i = 0;
		int j = 0;

		int star = -1;
		int idx = -1;

		while(i < s.length())
		{
			if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'))
			{
				i++;
				j++;
			}
			else if(j < p.length() && p.charAt(j) == '*')
			{
				star = j++;
				idx = i;
			}
			else if(star != -1)
			{
				i = ++idx;
				j = star + 1;
			}
			else
				return false;
		}

		while(j < p.length() && p.charAt(j) == '*')
			j++;

		return p.length() == j;
	}
}