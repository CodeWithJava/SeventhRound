public class Solution
{
	public String multiply(String num1, String num2)
	{
		if(num1 == null || num2 == null)
			return "";

		if(num1.length() == 0 || num2.length() == 0)
			return "";

		String x = new StringBuilder(num1).reverse().toString();
		String y = new StringBuilder(num2).reverse().toString();

		int m = x.length();
		int n = y.length();

		int [] digits = new int [m + n + 1];

		for(int i = 0;i < m;i++)
			for(int j = 0;j < n;j++)
				digits[i + j] += (x.charAt(i) - '0') * (y.charAt(j) - '0');

		StringBuilder sb = new StringBuilder();

		for(int i = 0;i < digits.length;i++)
		{
			int digit = digits[i] % 10;
			int carry = digits[i] / 10;

			if(i < digits.length - 1)
				digits[i + 1] += carry;

			sb.insert(0, digit);
		}

		while(sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);

		return sb.toString();
	}
}