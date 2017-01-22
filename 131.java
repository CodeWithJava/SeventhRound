public class Solution
{
	public List<List<String>> partition(String s)
	{
		List<List<String>> result = new ArrayList<>();
		List<String> t = new ArrayList<>();

		if(s == null || s.length() == 0)
		{
			t.add("");
			result.add(new ArrayList<>(t));
			return result;
		}

		traversal(s, 0, t, result);

		return result;
	}

	private void traversal(String s, int start, List<String> t, List<List<String>> result)
	{
		if(start == s.length())
			result.add(new ArrayList<>(t));
		else
		{
			for(int i = start + 1;i <= s.length();i++)
			{
				String sub = s.substring(start, i);

				if(isPalindrome(sub))
				{
					t.add(sub);
					traversal(s, i, t, result);
					t.remove(t.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s)
	{
		int i = 0;
		int j = s.length() - 1;

		while(i < j)
		{
			if(s.charAt(i++) != s.charAt(j--))
				return false;
		}

		return true;
	}
}