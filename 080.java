public class Solution
{
	public int removeDuplicates(int [] nums)
	{
		if(nums == null)
			return 0;

		if(nums.length < 3)
			return nums.length;

		int prev = 1;
		int curr = 2;

		while(curr < nums.length)
		{
			if(nums[curr] == nums[prev] && nums[curr] == nums[prev - 1])
				curr++;
			else
				nums[++prev] = nums[curr++];
		}

		return ++prev;
	}
}