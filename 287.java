// Solution One
public class Solution
{
	public int findDuplicate(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int fast = 0;
		int slow = 0;

		do
		{
			fast = nums[nums[fast]];
			slow = nums[slow];
		}
		while(fast != slow);

		fast = 0;

		while(fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
		}

		return fast;
	}
}

// Solution Two
public class Solution
{
	public int findDuplicate(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int l = 1;
		int r = nums.length - 1;

		while(l <= r)
		{
			int c = 0;
			int m = l + (r - l) / 2;

			for(int x: nums)
				if(x <= m)
					c++;

			if(c > m)
				r = m - 1;
			else
				l = m + 1;
		}

		return l;
	}
}