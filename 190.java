public class Solution
{
	public int reverseBits(int n)
	{
		if(n == 0)
			return 0;

		int result = 0;

		for(int i = 0;i < 32;i++)
		{
			if(((n >>> i) & 1) == 1)
				result++;

			if(i < 31)
				result <<= 1;
		}

		return result;
	}
}