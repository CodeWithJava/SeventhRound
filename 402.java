public class Solution
{
	public String removeKdigits(String num, int k)
	{
		if(num == null || num.length() == 0 || k < 1)
			return num;

		int digits = num.length() - k;
		char [] stack = new char [num.length()];
		int top = 0;

		for(int i = 0;i < num.length();i++)
		{
			char c = num.charAt(i);

			while(top > 0 && stack[top - 1] > c && k > 0)
			{
				top--;
				k--;
			}

			stack[top++] = c;
		}

		int idx = 0;

		while(idx < digits && stack[idx] == '0') idx++;

		return idx == digits ? "0":new String(stack, idx, digits - idx);
	}
}