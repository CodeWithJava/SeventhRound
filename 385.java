public class Solution
{
	public NestedInteger deserialize(String s)
	{
		if(s == null || s.length() == 0)
			return null;

		if(s.contains("["))
		{
			NestedInteger ni = new NestedInteger();

			if(s.length() > 2)
			{
				char [] x = s.toCharArray();

				int begin = 1;
				int count = 0;

				for(int i = 1;i < s.length() - 1;i++)
				{
					if(x[i] == ',' && count == 0)
					{
						ni.add(deserialize(s.substring(begin, i)));
						begin = i + 1;
					}

					if(x[i] == '[' || x[i] == ']')
						count += 92 - x[i];
				}

				ni.add(deserialize(s.substring(begin, s.length() - 1)));
			}

			return ni;
		}

		return new NestedInteger(Integer.valueOf(s));
	}
}