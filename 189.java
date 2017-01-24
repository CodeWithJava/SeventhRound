public class Solution
{
	public void rotate(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 1)
			return;

		k %= nums.length;

		rotate(nums, 0, nums.length - 1);
		rotate(nums, 0, k - 1);
		rotate(nums, k, nums.length - 1);
	}

	private void rotate(int [] nums, int i, int j)
	{
		while(i < j)
		{
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}
	}
}