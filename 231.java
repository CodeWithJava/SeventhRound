// Solution One
class Solution {
	public boolean isPowerOfTwo(int n) {
		if (n < 1) {
			return false;
		}

		long x = (long)n;
		return (x & (x - 1)) == 0;
	}
}

// Solution Two
public class Solution
{
	public boolean isPowerOfTwo(int n)
	{
		if(n < 1)
			return false;

		return Math.abs(Math.pow(2, Math.round(Math.log(n) / Math.log(2))) - n) < 0.00001;
	}
}
