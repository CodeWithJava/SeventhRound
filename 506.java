public class Solution
{
	public String [] findRelativeRanks(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return new String [0];

		int [][] pairs = new int [nums.length][2];

		for(int i = 0;i < nums.length;i++)
		{
			pairs[i][0] = nums[i];
			pairs[i][1] = i;
		}

		Arrays.sort(pairs, (p, q) -> (q[0] - p[0]));

		String [] result = new String [nums.length];

		for(int i = 0;i < nums.length;i++)
		{
			if(i == 0)
				result[pairs[i][1]] = "Gold Medal";
			else if(i == 1)
				result[pairs[i][1]] = "Silver Medal";
			else if(i == 2)
				result[pairs[i][1]] = "Bronze Medal";
			else
				result[pairs[i][1]] = String.valueOf(i + 1);
		}

		return result;
	}
}