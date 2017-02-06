public class Solution
{
	public int countPrimes(int n)
	{
		if(n < 2)
			return 0;

		int [] compose = new int [n];
		compose[0] = 1;
		compose[1] = 1;

		for(int i = 2;i * i < n;i++)
		{
			if(i == 2)
			{
				int x = 4;

				while(x < n)
				{
					compose[x] = 1;
					x += 2;
				}
			}
			else
			{
				if(compose[i] == 0)
				{
					int x = i * i;

					while(x < n)
					{
						compose[x] = 1;
						x += i * 2;
					}
				}
			}
		}

		int count = 0;

		for(int i = 0;i < n;i++)
			if(compose[i] == 0)
				count++;

		return count;
	}
}