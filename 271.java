public class Codec
{
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs)
	{
		StringBuilder sb = new StringBuilder();

		if(strs == null || strs.size() == 0)
			return sb.toString();

		for(String str: strs)
			sb.append(str.length() + "*" + str);

		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0)
			return result;

		int i = 0;

		while(i < s.length())
		{
			int idx = s.indexOf("*", i);
			int size = Integer.valueOf(s.substring(i, idx));
			result.add(s.substring(idx + 1, idx + 1 + size));
			i = idx + 1 + size;
		}

		return result;
	}
}