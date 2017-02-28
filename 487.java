// Solution
public class Solution
{
	public int findMaxConsecutiveOnes(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int max = 0;
		int zero = 0;
		int k = 1;
		int l = 0;

		for(int r = 0;r < nums.length;r++)
		{
			if(nums[r] == 0)
				zero++;

			while(zero > k)
				if(nums[l++] == 0)
					zero--;

			max = Math.max(max, r - l + 1);
		}

		return max;
	}
}

// Follow up
public class Solution
{
	public int findMaxConsecutiveOnes(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int max = 0;
		int k = 1;
		int l = 0;
		Queue<Integer> zeroIdx = new LinkedList<>();

		for(int r = 0;r < nums.length;r++)
		{
			if(nums[r] == 0)
				zeroIdx.offer(r);

			if(zeroIdx.size() > k)
				l = zeroIdx.poll() + 1;

			max = Math.max(max, r - l + 1);
		}

		return max;
	}
}

// For Max Consecutive Ones I
public class Solution
{
	public int findMaxConsecutiveOnes(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int max = 0;
		int zeroIdx = -1;
		int l = 0;

		for(int r = 0;r < nums.length;r++)
		{
			if(nums[r] == 0)
			{
				l = zeroIdx + 1;
				zeroIdx = r;
			}

			max = Math.max(max, r - l + 1);
		}

		return max;
	}
}