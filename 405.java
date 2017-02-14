public class Solution
{
	public String toHex(int num)
	{
		if(num == 0)
			return "0";

		Map<Integer, Character> map = new HashMap<>();
		map.put(10, 'a');
		map.put(11, 'b');
		map.put(12, 'c');
		map.put(13, 'd');
		map.put(14, 'e');
		map.put(15, 'f');

		StringBuilder sb = new StringBuilder();

		while(num != 0)
		{
			int x = num & 0xF;
			num >>>= 4;

			if(x < 10)
				sb.insert(0, x);
			else
				sb.insert(0, map.get(x));
		}

		return sb.toString();
	}
}