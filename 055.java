// Solution One
// Forward Idea
public class Solution
{
	public boolean canJump(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return true;

		int max = 0;

		for(int i = 0;i < nums.length;i++)
		{
			if(max <= i && nums[i] == 0)
				return false;

			if(max < i + nums[i])
				max = i + nums[i];

			if(max >= nums.length - 1)
				return true;
		}

		return false;
	}
}

// Solution Two
// Backward Idea It is easy to explain during the interview
// Source: https://www.youtube.com/watch?v=m6AymRRYgko
// Recommand to subscribe that account
class Solution {
    public boolean canJump(int [] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int curr = nums.length - 1;

        for (int i = nums.length - 2;i >= 0;i--) {
            if (i + nums[i] >= curr) {
                curr = i;
            }
        }

        return curr == 0;
    }
}
