public class Solution
{
	public String reverseWords(String s)
	{
		if(s == null || s.length() == 0)
			return s;

		char [] x = s.toCharArray();

		int i = 0;

		for(int j = 0;j < s.length();j++)
		{
			if(j == s.length() - 1)
			{
				swap(x, i, j);
				break;
			}
			else if(x[j] == ' ')
			{
				swap(x, i, j - 1);
				i = j + 1;
			}
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