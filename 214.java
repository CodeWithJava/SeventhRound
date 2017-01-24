public class Solution
{
	public String shortestPalindrome(String s)
	{
		if(s == null || s.length() == 0)
			return s;

		int l = 0;
		int r = s.length() - 1;

		while(r >= 0)
		{
			if(s.charAt(l) == s.charAt(r))
				l++;

			r--;
		}

		if(l == s.length())
			return s;

		String suffix = s.substring(l);
		String prefix = new StringBuilder(suffix).reverse().toString();
		String middle = shortestPalindrome(s.substring(0, l));

		return prefix + middle + suffix;
	}
}