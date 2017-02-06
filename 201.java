public class Solution
{
	public int rangeBitwiseAnd(int m, int n)
	{
		if(m < 0 || n < 0 || m > Integer.MAX_VALUE || n > Integer.MAX_VALUE || m > n)
			return 0;

		while(m < n)
			n &= n - 1;

		return m & n;
	}
}