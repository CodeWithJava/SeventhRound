public class Solution
{
	public int longestSubstring(String s, int k)
	{
		if(s == null || s.length() == 0 || k < 0)
			return 0;

		return traversal(s.toCharArray(), 0, s.length(), k);
	}

	private int traversal(char [] x, int l, int r, int k)
	{
		if(r - l < k)
			return 0;

		int [] map = new int [26];

		for(int i = l;i < r;i++)
			map[x[i] - 'a']++;

		for(int i = 0;i < 26;i++)
		{
			if(map[i] < k && map[i] > 0)
			{
				for(int j = l;j < r;j++)
				{
					if(x[j] == i + 'a')
						return Math.max(traversal(x, l, j, k), traversal(x, j + 1, r, k));
				}
			}
		}

		return r - l;
	}
}