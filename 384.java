public class Solution
{
	int [] clone;
	Random r;

	Solution(int [] nums)
	{
		clone = nums;
		r = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int [] reset()
	{
		return clone;
	}

	/** Returns a random shuffling of the array. */
	public int [] shuffle()
	{
		if(clone == null)
			return null;

		int l = clone.length;
		int [] result = clone.clone();

		for(int i = l - 1;i >= 0;i--)
		{
			int idx = r.nextInt(i + 1);

			int t = result[i];
			result[i] = result[idx];
			result[idx] = t;
		}

		return result;
	}
}