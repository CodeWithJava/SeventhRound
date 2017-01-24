public class Solution
{
	public boolean isOneEditDistance(String s, String t)
	{
		if((s == null || s.length() == 0) && (t == null || t.length() == 0))
			return false;

		if((s == null || s.length() == 0) && t.length() == 1)
			return true;

		if((t == null || t.length() == 0) && s.length() == 1)
			return true;

		int m = s.length();
		int n = t.length();

		if(Math.abs(m - n) > 1)
			return false;

		String x = m < n ? s:t;
		String y = m < n ? t:s;

		if(m == n)
		{
			int i = 0;
			int count = 0;

			while(i < x.length())
			{
				if(x.charAt(i) != y.charAt(i))
				{
					if(++count > 1)
						return false;
				}

				i++;
			}

			return count == 1;
		}
		else
		{
			int i = 0;
			int j = 0;
			int count = 0;

			while(i < x.length())
			{
				if(x.charAt(i) == y.charAt(j))
				{
					i++;
					j++;
				}
				else
				{
					if(++count > 1)
						return false;
					j++;
				}
			}

			return true;
		}
	}
}