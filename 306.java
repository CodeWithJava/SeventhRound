public class Solution
{
	public boolean isAdditiveNumber(String num)
	{
		if(num == null || num.length() < 3)
			return false;

		int l = num.length();

		for(int i = 1;i <= l / 2;i++)
		{
			if(i > 1 && num.charAt(0) == '0')
				return false;

			long x1 = Long.valueOf(num.substring(0, i));

			for(int j = 1;Math.max(i, j) <= l - i - j;j++)
			{
				if(j > 1 && num.charAt(i) == '0')
					break;

				long x2 = Long.valueOf(num.substring(i, i + j));

				if(isValid(x1, x2, i + j, num))
					return true;
			}
		}

		return false;
	}

	private boolean isValid(long x1, long x2, int start, String num)
	{
		if(start == num.length())
			return true;

		x2 = x2 + x1;
		x1 = x2 - x1;

		String sum = String.valueOf(x2);

		return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
	}
}