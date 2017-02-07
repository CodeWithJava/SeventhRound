public class Solution
{
	public void wiggleSort(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return;

		Arrays.sort(nums);

		int [] t = new int [nums.length];
		int m = nums.length / 2;

		if(nums.length % 2 != 0)
			m++;

		int l = m - 1;
		int r = nums.length - 1;

		for(int i = 0;i < nums.length;i++)
		{
			if(i % 2 == 0)
				t[i] = nums[l--];
			else
				t[i] = nums[r--];
		}

		for(int i = 0;i < nums.length;i++)
			nums[i] = t[i];
	}
}