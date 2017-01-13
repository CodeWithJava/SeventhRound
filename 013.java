public class Solution
{
	public int romanToInt(String s)
	{
		if(s == null || s.length() == 0)
			throw new IllegalArgumentException("Input is invalid");

		Map<Character, Integer> map = new HashMap<>();
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);

		int result = 0;
		int prev = 0;

		for(char x: s.toCharArray())
		{
			int curr = map.get(x);
			result += prev < curr ? (curr - prev * 2):curr;
			prev = curr;
		}

		return result;
	}
}