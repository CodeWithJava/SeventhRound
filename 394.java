public class Solution
{
	public String decodeString(String s)
	{
		if(s == null || s.length() == 0)
			return s;

		String str = "";

		Stack<Integer> repeat = new Stack<>();
		Stack<String> strs = new Stack<>();

		int idx = 0;

		while(idx < s.length())
		{
			if(Character.isDigit(s.charAt(idx)))
			{
				int count = 0;

				while(Character.isDigit(s.charAt(idx)))
					count = count * 10 + (s.charAt(idx++) - '0');

				repeat.push(count);
			}
			else if(s.charAt(idx) == '[')
			{
				strs.push(str);
				str = "";
				idx++;
			}
			else if(s.charAt(idx) == ']')
			{
				StringBuilder sb = new StringBuilder(strs.pop());
				int times = repeat.pop();

				for(int i = 0;i < times;i++)
					sb.append(str);

				str = sb.toString();
				idx++;
			}
			else
				str += s.charAt(idx++);
		}

		return str;
	}
}