public class Solution
{
	public String reverseStr(String s, int k)
	{
		if(s == null || s.length() == 0 || k < 1)
			return s;

		char [] x = s.toCharArray();
		int i = 0;

		while(i < s.length())
		{
			int j = Math.min(i + k - 1, s.length() - 1);
			swap(x, i, j);
			i += k * 2;
		}

		return new String(x);
	}

	private void swap(char [] x, int i, int j)
	{
		while(i < j)
		{
			char t = x[i];
			x[i] = x[j];
			x[j] = t;

			i++;
			j--;
		}
	}
}