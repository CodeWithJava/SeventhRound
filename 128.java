public class Solution
{
	public int longestConsecutive(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		Set<Integer> set = new HashSet<>();

		for(int x: nums)
			set.add(x);

		int max = 1;

		for(int x: nums)
		{
			int count = 1;

			int l = x - 1;

			while(set.contains(l))
			{
				count++;
				set.remove(l--);
			}

			int r = x + 1;

			while(set.contains(r))
			{
				count++;
				set.remove(r++);
			}

			max = Math.max(max, count);
		}

		return max;
	}
}