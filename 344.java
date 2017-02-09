public class Solution
{
	public String reverseString(String s)
	{
		if(s == null || s.length() < 2)
			return s;

		char [] x = s.toCharArray();

		int l = 0;
		int r = x.length - 1;

		while(l < r)
		{
			char t = x[l];
			x[l] = x[r];
			x[r] = t;

			l++;
			r--;
		}

		return new String(x);
	}
}