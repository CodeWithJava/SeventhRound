public class Solution
{
	public int mySqrt(int x)
	{
		if(x < 0)
			throw new IllegalArgumentException("Input is invalid");

		if(x == 0)
			return 0;

		double prev = 0.0;
		double result = 1.0;

		while(prev != result)
		{
			prev = result;
			result = (result + x / result) / 2;
		}

		return (int)result;
	}
}