public class NumArray
{
	int [] x;

	NumArray(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		int l = nums.length;

		x = new int [l];

		x[0] = nums[0];

		for(int i = 1;i < l;i++)
			x[i] = nums[i] + x[i - 1];
	}

	public int sumRange(int i, int j)
	{
		if(i == 0)
			return x[j];
		else
			return x[j] - x[i - 1];
	}
}