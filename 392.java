public class Solution
{
	public boolean isSubsequence(String s, String t)
	{
		if(s == null || s.length() == 0)
			return true;

		if(t == null || t.length() == 0)
			return false;

		int i = t.indexOf(s.charAt(0), 0);

		if(i == -1)
			return false;

		for(int i = 1;i < s.length();i++)
		{
			i = t.indexOf(s.charAt(i), i + 1);

			if(i == -1)
				return false;
		}

		return true;
	}
}