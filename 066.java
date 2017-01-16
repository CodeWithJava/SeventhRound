public class Solution
{
	public int [] plusOne(int [] digits)
	{
		if(digits == null || digits.length == 0)
			return new int [] {1};

		int notNine = -1;

		for(int i = 0;i < digits.length;i++)
		{
			if(digits[i] != 9)
				notNine = i;
		}

		if(notNine == -1)
		{
			int [] result = new int [digits.length + 1];
			result[0] = 1;
			return result;
		}

		for(int i = notNine + 1;i < digits.length;i++)
			digits[i] = 0;

		digits[notNine]++;

		return digits;
	}
}