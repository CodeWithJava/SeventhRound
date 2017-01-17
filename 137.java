// Solution One
public class Solution
{
	public int singleNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int one = 0;
		int two = 0;
		int three = 0;

		for(int x: nums)
		{
			two |= one & x;
			one ^= x;
			three = one & two;
			one &= ~three;
			two &= ~three;
		}

		return one;
	}
}

// Solution Two
public class Solution
{
	public int singleNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;

		for(int i = 0;i < 32;i++)
		{
			int bit = 0;

			for(int x: nums)
				if(((x >> i) & 1) == 1)
					bit++;

			result |= (bit % 3) << i;
		}

		return result;
	}
}