public class Solution
{
	public String addStrings(String nums1, String nums2)
	{
		if(nums1 == null || nums1.length() == 0)
			return nums2;

		if(nums2 == null || nums2.length() == 0)
			return nums1;

		int m = nums1.length();
		int n = nums2.length();

		StringBuilder sb = new StringBuilder();

		int carry = 0;

		while(m > 0 || n > 0)
		{
			int p = 0;

			if(m > 0)
				p = nums1.charAt(--m) - '0';

			int q = 0;

			if(n > 0)
				q = nums2.charAt(--n) - '0';

			int sum = carry + p + q;

			if(sum >= 10)
			{
				carry = 1;
				sb.insert(0, sum - 10);
			}
			else
			{
				carry = 0;
				sb.insert(0, sum);
			}
		}

		if(carry != 0)
			sb.insert(0, carry);

		return sb.toString();
	}
}