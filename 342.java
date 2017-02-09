public class Solution
{
	public boolean isPowerOfFour(int num)
	{
		if(num < 1)
			return false;

		if(num == 1)
			return true;

		return Math.abs(Math.pow(4, Math.round(Math.log(num) / Math.log(4))) - num) < 0.00001;
	}
}