public class Solution
{
	public String reverseVowels(String s)
	{
		if(s == null || s.length() < 2)
			return s;

		String vowels = "aeiouAEIOU";

		char [] x = s.toCharArray();

		int l = 0;
		int r = x.length - 1;

		while(l < r)
		{
			if(l < r && !vowels.contains(String.valueOf(x[l])))
			{
				l++;
				continue;
			}

			if(l < r && !vowels.contains(String.valueOf(x[r])))
			{
				r--;
				continue;
			}

			char t = x[l];
			x[l] = x[r];
			x[r] = t;

			l++;
			r--;
		}

		return new String(x);
	}
}