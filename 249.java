public class Solution
{
	public List<List<String>> groupStrings(String [] strings)
	{
		List<List<String>> result = new ArrayList<>();

		if(strings == null || strings.length == 0)
			return result;

		for(String str: strings)
		{
			boolean newGroup = true;

			for(List<String> x: result)
			{
				if(isSameGroup(str, x.get(0)))
				{
					x.add(str);
					newGroup = false;
					break;
				}
			}

			if(newGroup)
			{
				List<String> t = new ArrayList<>();
				t.add(str);
				result.add(new ArrayList<>(t));
			}
		}

		return result;
	}

	private boolean isSameGroup(String s, String t)
	{
		if(s.length() != t.length())
			return false;

		for(int i = 1;i < s.length();i++)
		{
			int delta1 = s.charAt(i) - t.charAt(i);
			delta1 = delta1 < 0 ? delta1 + 26:delta1;
			int delta2 = s.charAt(i - 1) - t.charAt(i - 1);
			delta2 = delta2 < 0 ? delta2 + 26:delta2;

			if(delta1 != delta2)
				return false;
		}

		return true;
	}
}