public class Solution
{
	public int [] singleNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return new int [0];

		int x1XORx2 = 0;

		for(int x: nums)
			x1XORx2 ^= x;

		int lastBitOne = x1XORx2 - (x1XORx2 & (x1XORx2 - 1));

		int x1 = 0;
		int x2 = 0;

		for(int x: nums)
		{
			if((x & lastBitOne) == 0)
				x1 ^= x;
			else
				x2 ^= x;
		}

		return new int [] {x1, x2};
	}
}