public class Solution
{
	public boolean isPerfectSquare(int num)
	{
		if(num < 1)
			return false;

		long x = num;

		while(x * x > num)
			x = (x + num / x) / 2;

		return x * x == num;
	}
}