// Solution One
public class Solution
{
	public List<String> generateAbbreviations(String word)
	{
		List<String> result = new ArrayList<>();

		if(word == null)
			return result;

		if(word.length() == 0)
		{
			result.add(new String(""));
			return result;
		}

		traversal(word, 0, "", result);

		return result;
	}

	private void traversal(String word, int start, String curr, List<String> result)
	{
		result.add(curr + word.substring(start));

		if(start == word.length())
			return;
		else
		{
			int i = 0;

			if(start != 0)
				i = start + 1;

			while(i < word.length())
			{
				String prefix = curr + word.substring(start, i);

				for(int j = 1;j <= word.length() - i;j++)
					traversal(word, i + j, prefix + j, result);

				i++;
			}
		}
	}
}

// Solution Two
public class Solution
{
	public List<String> generateAbbreviations(String word)
	{
		List<String> result = new ArrayList<>();

		if(word == null)
			return result;

		if(word.length() == 0)
		{
			result.add(new String(""));
			return result;
		}

		for(int x = 0;x < (1 << word.length());x++)
			result.add(abbreviation(word, x));

		return result;
	}

	private String abbreviation(String word, int x)
	{
		StringBuilder sb = new StringBuilder();

		int k = 0;
		int l = word.length();
		int i = 0;

		while(i < l)
		{
			if((x & 1) == 0)
			{
				if(k != 0)
				{
					sb.append(k);
					k = 0;
				}

				sb.append(word.charAt(i));
			}
			else
				k++;

			i++;
			x >>= 1;
		}

		if(k != 0)
			sb.append(k);

		return sb.toString();
	}
}