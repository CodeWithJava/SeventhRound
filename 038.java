public class Solution
{
	public String countAndSay(int n)
	{
		if(n < 1)
			return "";

		String result = "1";

		while(n > 1)
		{
			StringBuilder sb = new StringBuilder();
			int count = 1;

			for(int i = 1;i < result.length();i++)
			{
				if(result.charAt(i - 1) == result.charAt(i))
					count++;
				else
				{
					sb.append(count);
					sb.append(result.charAt(i -1));
					count = 1;
				}
			}

			sb.append(count);
			sb.append(result.charAt(result.length() - 1));

			result = sb.toString();

			n--;
		}

		return result;
	}
}