public class Solution
{
	public int maximumGap(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return 0;

		int max = nums[0];
		int min = nums[0];

		for(int x: nums)
		{
			max = Math.max(max, x);
			min = Math.min(min, x);
		}

		Bucket [] buckets = new Bucket [nums.length + 1];

		for(int i = 0;i <= nums.length;i++)
			buckets[i] = new Bucket();

		double interval = (double) nums.length / (max - min);

		for(int i = 0;i < nums.length;i++)
		{
			int idx = (int) ((nums[i] - min) * interval);

			if(buckets[idx].l == -1)
			{
				buckets[idx].l = nums[i];
				buckets[idx].r = nums[i];
			}
			else
			{
				buckets[idx].l = Math.min(buckets[idx].l, nums[i]);
				buckets[idx].r = Math.max(buckets[idx].r, nums[i]);
			}
		}

		int gap = 0;
		int prev = buckets[0].r;

		for(int i = 1;i <= nums.length;i++)
		{
			if(buckets[i].l != -1)
			{
				gap = Math.max(gap, buckets[i].l - prev);
				prev = buckets[i].r;
			}
		}

		return gap;
	}
}
class Bucket
{
	int l;
	int r;

	Bucket()
	{
		l = -1;
		r = -1;
	}
}