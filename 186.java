public class Solution
{
	public void reverseWords(char [] s)
	{
		if(s == null || s.length == 0)
			return;

		reverse(s, 0, s.length - 1);

		int i = 0;

		for(int j = 0;j < s.length;j++)
		{
			if(s[j] == ' ')
				i = j + 1;
			else if(j == s.length - 1 || s[j + 1] == ' ')
				reverse(s, i, j);
		}
	}

	private void reverse(char [] s, int i, int j)
	{
		while(i < j)
		{
			char t = s[i];
			s[i] = s[j];
			s[j] = t;

			i++;
			j--;
		}
	}
}