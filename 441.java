public class Solution
{
	public int arrangeCoins(int n)
	{
		if(n < 1)
			return 0;

		int i = 1;

		while(i < n)
		{
			n -= i;
			i++;
		}

		return i == n ? i:i - 1;
	}
}