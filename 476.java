public class Solution
{
	public int findComplement(int num)
	{
		if(num < 1)
			throw new IllegalArgumentException("Input must be positive");

		int result = 0;

		for(int i = 0;i < 32;i++)
		{
			if(num == 0)
				break;

			if((num & 1) == 0)
				result |= 1 << i;

		    num >>= 1;
		}

		return result;
	}
}