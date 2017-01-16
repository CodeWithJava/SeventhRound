public class Solution
{
	public String addBinary(String a, String b)
	{
		if(a == null || a.length() == 0)
			return b;

		if(b == null || b.length() == 0)
			return a;

		StringBuilder sb = new StringBuilder();

		int m = a.length();
		int n = b.length();

		int carry = 0;

		while(m > 0 || n > 0)
		{
			int p = 0;

			if(m > 0)
				p = a.charAt(--m) == '0' ? 0:1;

			int q = 0;

			if(n > 0)
				q = b.charAt(--n) == '0' ? 0:1;

			int sum = carry + p + q;

			if(sum >= 2)
			{
				carry = 1;
				sb.insert(0, sum - 2);
			}
			else
			{
				carry = 0;
				sb.insert(0, sum);
			}
		}

		if(carry != 0)
			sb.insert(0, carry);

		return sb.toString();
	}
}