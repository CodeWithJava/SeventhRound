public class Solution
{
	public int [] countBits(int num)
	{
		if(num < 0)
			return new int [0];

		int [] result = new int [num + 1];

		int pow = 1;
		int p = 1;

		for(int i = 1;i <= num;i++)
		{
			if(i == pow)
			{
				result[i] = 1;
				pow <<= 1;
				p = 1;
			}
			else
			{
				result[i] = result[p] + 1;
				p++;
			}
		}

		return result;
	}
}