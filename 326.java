public class Solution
{
	public boolean isPowerOfThree(int n)
	{
		if(n < 1)
			return false;

		if(n == 1)
			return true;

		return Math.abs(Math.pow(3, Math.round(Math.log(n) / Math.log(3))) - n) < 0.00001;
	}
}