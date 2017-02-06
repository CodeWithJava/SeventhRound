public class Solution
{
	public String fractionToDecimal(int numerator, int denominator)
	{
		if(denominator == 0)
			return "";

		if(numerator == 0)
			return "0";

		String result = "";

		if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)
			result += "-";

		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);

		long quotient = num / den;
		long remainder = num % den;

		result += String.valueOf(quotient);

		if(remainder == 0)
			return result;

		remainder *= 10;

		result += ".";

		Map<Long, Integer> map = new HashMap<>();

		while(remainder != 0)
		{
			if(map.containsKey(remainder))
			{
				int i = map.get(remainder);

				String part1 = result.substring(0, i);
				String part2 = result.substring(i);

				return part1 + "(" + part2 + ")";
			}

			map.put(remainder, result.length());

			quotient = remainder / den;
			result += String.valueOf(quotient);
			remainder = (remainder % den) * 10;
		}

		return result;
	}
}