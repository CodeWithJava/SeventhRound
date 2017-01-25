public class Solution extends VersionControl
{
	public int firstBadVersion(int n)
	{
		if(n < 1)
			return -1;

		Solution a = new Solution();

		int l = 1;
		int r = n;

		while(l < r)
		{
			int m = l + (r - l) / 2;

			if(a.isBadVersion(m))
				r = m;
			else
				l = m + 1;
		}

		return l;
	}
}