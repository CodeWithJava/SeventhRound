public class Solution
{
	Map<Integer, String> map;

	public List<String> letterCombinations(String digits)
	{
		List<String> result = new ArrayList<>();

		if(digits == null || digits.length() == 0)
			return result;

		map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");

		List<Character> t = new ArrayList<>();

		traversal(digits, t, result);

		return result;
	}

	private void traversal(String digits, List<Character> t, List<String> result)
	{
		if(digits.length() == 0)
		{
			StringBuilder sb = new StringBuilder();

			for(char x: t)
				sb.append(x);

			result.add(sb.toString());
		}
		else
		{
			int digit = Integer.valueOf(digits.substring(0, 1));
			String letters = map.get(digit);

			for(int i = 0;i < letters.length();i++)
			{
				t.add(letters.charAt(i));
				traversal(digits.substring(1), t, result);
				t.remove(t.size() - 1);
			}
		}
	}
}