public class Solution
{
	int [] x;
	Random r;

	public Solution(int [] nums)
	{
		this.x = nums;
		r = new Random();
	}

	public int pick(int target)
	{
		int result = -1;
		int count = 0;

		for(int i = 0;i < x.length;i++)
		{
			if(x[i] != target)
				continue;

			if(r.nextInt(++count) == 0)
				result = i;
		}

		return result;
	}
}