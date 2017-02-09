public class Solution
{
	public int getSum(int a, int b)
	{
		if(b == 0)
			return a;

		while(b != 0)
		{
			int c = a & b;
			a ^= b;
			b = c << 1;
		}

		return a;
	}
}