public class Solution
{
	public int hammingDistance(int x, int y)
	{
		return countBitOne(x ^ y);
	}

	private int countBitOne(int x)
	{
		int count = 0;

		for(int i = 0;i < 32;i++)
		{
			if((x & 1) == 1)
				count++;

			x >>= 1;
		}

		return count;
	}
}