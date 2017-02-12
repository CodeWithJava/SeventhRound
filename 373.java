public class Solution
{
	public List<int []> kSmallestPairs(int [] nums1, int [] nums2, int k)
	{
		List<int []> result = new ArrayList<>();

		if(nums1 == null || nums2 == null || k < 1)
			return result;

		k = Math.min(k, nums1.length * nums2.length);

		if(k == 0)
			return result;

		int [] idx = new int [nums1.length];

		while(k > 0)
		{
			int min = Integer.MAX_VALUE;
			int t = 0;

			for(int i = 0;i < nums1.length;i++)
			{
				if(idx[i] < nums2.length && nums1[i] + nums2[idx[i]] < min)
				{
					min = nums1[i] + nums2[idx[i]];
					t = i;
				}
			}

			result.add(new int [] {nums1[t], nums2[idx[t]]});
			idx[t]++;

			k--;
		}

		return result;
	}
}