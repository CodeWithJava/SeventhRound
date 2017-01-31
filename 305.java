public class Solution
{
	public List<Integer> numIslands2(int m, int n, int [][] positions)
	{
		List<Integer> result = new ArrayList<>();

		if(m < 1 || n < 1 || positions == null || positions.length == 0)
			return result;

		int [] root = new int [m * n];
		Arrays.fill(root, -1);

		int [][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		int count = 0;

		for(int [] p: positions)
		{
			count++;

			int idx = p[0] * n + p[1];
			root[idx] = idx;

			for(int i = 0;i < dir.length;i++)
			{
				int x = p[0] + dir[i][0];
				int y = p[1] + dir[i][1];

				if(x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1 && root[x * n + y] != -1)
				{
					int thisRoot = getRoot(root, x * n + y);

					if(thisRoot != idx)
					{
						root[thisRoot] = idx;
						count--;
					}
				}
			}

			result.add(count);
		}

		return result;
	}

	private int getRoot(int [] root, int i)
	{
		while(i != root[i])
			i = root[root[i]];

		return i;
	}
}