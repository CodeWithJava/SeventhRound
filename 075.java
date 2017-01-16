public class Solution
{
	public void sortColors(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return;

		int i = 0;
		int l = 0;
		int r = nums.length - 1;

		while(i <= r)
		{
			if(nums[i] == 0)
			{
				swap(nums, l, i);
				l++;
				i++;
			}
			else if(nums[i] == 1)
			{
				i++;
			}
			else if(nums[i] == 2)
			{
				swap(nums, r, i);
				r--;
			}
		}
	}

	private void swap(int [] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}