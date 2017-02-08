public class Solution
{
	Set<String> set;

	public List<String> removeInvalidParentheses(String s)
	{
		set = new HashSet<>();

		if(s == null)
			return new ArrayList<>(set);

		if(s.length() == 0)
		{
			set.add("");
			return new ArrayList<>(set);
		}

		int rmL = 0;
		int rmR = 0;

		for(char x: s.toCharArray())
		{
			if(x == '(')
				rmL++;
			else if(x == ')')
			{
				if(rmL > 0)
					rmL--;
				else
					rmR++;
			}
		}

		remove(s, 0, rmL, rmR, 0, "");

		return new ArrayList<>(set);
	}

	private void remove(String s, int i, int rmL, int rmR, int open, String t)
	{
		if(i == s.length() && rmL == 0 && rmR == 0 && open == 0)
		{
			set.add(t);
			return;
		}

		if(i == s.length() || rmL < 0 || rmR < 0 || open < 0)
			return;

		char x = s.charAt(i);

		if(x == '(')
		{
			remove(s, i + 1, rmL - 1, rmR, open, t);
			remove(s, i + 1, rmL, rmR, open + 1, t + x);
		}
		else if(x == ')')
		{
			remove(s, i + 1, rmL, rmR - 1, open, t);
			remove(s, i + 1, rmL, rmR, open - 1, t + x);
		}
		else
			remove(s, i + 1, rmL, rmR, open, t + x);
	}
}