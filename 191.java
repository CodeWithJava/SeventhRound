public class Solution
{
	public int hammingWeight(int n)
	{
		if(n == 0)
			return 0;

		int count = 0;

		for(int i = 0;i < 32;i++)
		{
			if(((n >> i) & 1) == 1)
				count++;
		}

		return count;
	}
}