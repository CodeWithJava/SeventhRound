// Solution One
public class Solution
{
	public int findPeakElement(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return -1;

		if(nums.length == 1 || nums[0] > nums[1])
			return 0;

		for(int i = 1;i < nums.length - 1;i++)
			if(nums[i] > nums[i + 1])
				return i;

		if(nums[nums.length - 2] < nums[nums.length - 1])
			return nums.length - 1;

		return -1;
	}
}

// Solution Two
public class Solution
{
	public int findPeakElement(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return -1;

		if(nums.length == 1 || nums[0] > nums[1])
			return 0;

		int l = 0;
		int r = nums.length - 1;

		while(l + 1 < r)
		{
			int m = l + (r - l) / 2;

			if(nums[m - 1] < nums[m] && nums[m] > nums[m + 1])
				return m;
			else if(nums[m - 1] > nums[m])
				r = m;
			else
				l = m;
		}

		if(nums[l] > nums[r])
			return l;
		else
			return r;
	}
}