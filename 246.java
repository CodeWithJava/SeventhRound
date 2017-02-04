public class Solution
{
	public boolean isStrobogrammatic(String num)
	{
		if(num == null || num.length() == 0)
			return false;

		Map<Character, Character> map = new HashMap<>();

		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		int l = 0;
		int r = num.length() - 1;

		while(l <= r)
		{
			if(map.get(num.charAt(l++)) != (Character)(num.charAt(r--)))
				return false;
		}

		return true;
	}
}