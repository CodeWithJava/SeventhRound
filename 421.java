public class Solution
{
	public int findMaximumXOR(int [] nums)
	{
		int max = 0;
		int mask = 0;

		for(int i = 31;i >= 0;i--)
		{
			mask |= 1 << i;

			Set<Integer> set = new HashSet<>();

			for(int x: nums)
				set.add(x & mask);

			int t = max | (1 << i);

			for(int prefix: set)
			{
				if(set.contains(t ^ prefix))
				{
					max = t;
					break;
				}
			}
		}

		return max;
	}
}