public class Solution
{
	public boolean repeatedSubstringPattern(String str)
	{
		if(str == null || str.length() == 0)
			return true;

		int l = str.length();

		for(int i = l / 2;i > 0;i--)
		{
			if(l % i == 0)
			{
				int m = l / i;

				String repeated = str.substring(0, i);

				StringBuilder sb = new StringBuilder();

				for(int j = 0;j < m;j++)
					sb.append(repeated);

				if(sb.toString().equals(str))
					return true;
			}
		}

		return false;
	}
}