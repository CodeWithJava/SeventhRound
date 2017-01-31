public class NumArray
{
	int [] x;
	int [] bit;
	int l;

	NumArray(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		l = nums.length;
		x = new int [l];
		bit = new int [l + 1];

		for(int i = 0;i < l;i++)
			update(i, nums[i]);
	}

	public void update(int i, int val)
	{
		int delta = val - x[i];
		x[i] = val;

		for(int p = i + 1;p <= l;p += p & -p)
			bit[p] += delta;
	}

	public int sumRange(int i, int j)
	{
		return i == 0 ? query(j):query(j) - query(i - 1);
	}

	private int query(int i)
	{
		int sum = 0;

		for(int p = i + 1;p > 0;p -= p & -p)
			sum += bit[p];

		return sum;
	}
}