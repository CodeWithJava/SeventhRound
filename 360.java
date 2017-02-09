public class Solution
{
	public int [] sortTransformedArray(int [] nums, int a, int b, int c)
	{
		if(nums == null || nums.length == 0)
			return nums;

		int length = nums.length;
		int [] result = new int [length];

		int l = 0;
		int r = length - 1;

		int i = a >= 0 ? length - 1:0;

		while(l <= r)
		{
			if(a >= 0)
				result[i--] = calculate(nums[l], a, b, c) >= calculate(nums[r], a, b, c) ? calculate(nums[l++], a, b, c):calculate(nums[r--], a, b, c);
			else
				result[i++] = calculate(nums[l], a, b, c) <= calculate(nums[r], a, b, c) ? calculate(nums[l++], a, b, c):calculate(nums[r--], a, b, c);
		}

		return result;
	}

	private int calculate(int x, int a, int b, int c)
	{
		return a * x * x + b * x + c;
	}
}