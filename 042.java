public class Solution
{
	public int trap(int [] height)
	{
		if(height == null || height.length < 2)
			return 0;

		int length = height.length;

		int [] l = new int [length];
		l[0] = height[0];
		int max = height[0];

		for(int i = 1;i < length;i++)
		{
			if(height[i] > max)
				max = height[i];

			l[i] = max;
		}

		int [] r = new int [length];
		r[length - 1] = height[length - 1];
		max = height[length - 1];

		for(int i = length - 2;i >= 0;i--)
		{
			if(height[i] > max)
				max = height[i];

			r[i] = max;
		}

		int result = 0;

		for(int i = 0;i < length;i++)
			result += Math.min(l[i], r[i]) - height[i];

		return result;
	}
}