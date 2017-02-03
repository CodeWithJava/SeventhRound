public class Solution
{
	public List<String> fullJustify(String [] words, int maxWidth)
	{
		List<String> result = new ArrayList<>();

		if(words == null || words.length == 0 || maxWidth < 0)
			return result;

		int length = 0;
		int start = 0;

		for(int i = 0;i < words.length;i++)
		{
			length += words[i].length();

			if(length + i - start > maxWidth)
			{
				int wordLength = length - words[i].length();
				int spaceLength = maxWidth - wordLength;
				int gapLength = 1;
				int extraLength = 0;

				if(i - 1 - start > 0)
				{
					gapLength = spaceLength / (i - 1 - start);
					extraLength = spaceLength % (i - 1 - start);
				}

				StringBuilder sb = new StringBuilder();

				for(int j = start;j < i - 1;j++)
				{
					sb.append(words[j]);

					for(int k = 0;k < gapLength;k++)
						sb.append(" ");

					if(extraLength-- > 0)
						sb.append(" ");
				}

				sb.append(words[i - 1]);

				while(sb.length() < maxWidth)
					sb.append(" ");

				result.add(sb.toString());

				start = i;
				length = words[i].length();
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i = start;i < words.length - 1;i++)
			sb.append(words[i] + " ");

		sb.append(words[words.length - 1]);

		while(sb.length() < maxWidth)
			sb.append(" ");

		result.add(sb.toString());

		return result;
	}
}