public class Solution
{
	public int totalHammingDistance(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int distance = 0;

		for(int i = 0;i < 32;i++)
		{
			int bitCount = 0;

			for(int x: nums)
				bitCount += (x >> i) & 1;

			distance += bitCount * (nums.length - bitCount);
		}

		return distance;
	}
}