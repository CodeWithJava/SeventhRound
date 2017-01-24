public class Solution
{
	public int compareVersion(String version1, String version2)
	{
		if(version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0)
			throw new IllegalArgumentException("Input is invalid");

		String [] x = version1.split("\\.");
		String [] y = version2.split("\\.");

		int i = 0;

		while(i < x.length || i < y.length)
		{
			if(i < x.length && i < y.length)
			{
				int m = Integer.valueOf(x[i]);
				int n = Integer.valueOf(y[i]);

				if(m > n)
					return 1;
				else if(m < n)
					return -1;
			}
			else if(i < x.length)
			{
				int m = Integer.valueOf(x[i]);

				if(m != 0)
					return 1;
			}
			else if(i < y.length)
			{
				int n = Integer.valueOf(y[i]);

				if(n != 0)
					return -1;
			}

			i++;
		}

		return 0;
	}
}