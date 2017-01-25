// Solution One
public class Solution
{
	public void moveZeroes(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		int i = 0;
		int j = 0;

		while(i < nums.length)
		{
			if(nums[i] != 0)
				nums[j++] = nums[i];

			i++;
		}

		while(j < nums.length)
			nums[j++] = 0;
	}
}

// Solution Two
public class Solution
{
	public void moveZeroes(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		int i = 0;
		int j = 0;

		while(i < nums.length)
		{
			if(nums[i] != 0)
				swap(nums, j++, i);

			i++;
		}
	}

	private void swap(int [] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}