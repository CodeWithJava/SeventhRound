// Solution One
public class Solution
{
	public int longestValidParentheses(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();

		int max = 0;

		for(int i = 0;i < s.length();i++)
		{
			if(s.charAt(i) == '(')
				stack.push(i);
			else
			{
				if(stack.isEmpty() || s.charAt(stack.peek()) == ')')
					stack.push(i);
				else
				{
					stack.pop();
					max = Math.max(max, stack.isEmpty() ? i + 1:i - stack.peek());
				}
			}
		}

		return max;
	}
}

// Solution Two
public class Solution
{
	public int longestValidParentheses(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		int [] dp = new int [s.length()];

		int max = 0;

		for(int i = s.length() - 2;i >= 0;i--)
		{
			if(s.charAt(i) == '(')
			{
				int j = i + dp[i + 1] + 1;

				if(j < s.length() && s.charAt(j) == ')')
				{
					dp[i] = dp[i + 1] + 2;

					if(j < s.length() - 1)
						dp[i] += dp[j + 1];
				}

				max = Math.max(max, dp[i]);
			}
		}

		return max;
	}
}