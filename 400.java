public class Solution
{
	public int findNthDigit(int n)
	{
		if(n < 1)
			return -1;

		int l = 1;
		long count = 9;
		int start = 1;

		while(n > l * count)
		{
			n -= l * count;
			l++;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / l;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % l));
	}
}