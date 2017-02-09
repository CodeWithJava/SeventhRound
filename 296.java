public class Solution
{
	public int minTotalDistance(int [][] grid)
	{
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();

		int r = grid.length;
		int c = grid[0].length;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(grid[i][j] == 1)
				{
					x.add(j);
					y.add(i);
				}
			}
		}

		return getMin(x) + getMin(y);
	}

	private int getMin(List<Integer> list)
	{
		if(list == null || list.size() == 0)
			return 0;

		Collections.sort(list);

		int l = 0;
		int r = list.size() - 1;

		int x = 0;

		while(l < r)
			x += list.get(r--) - list.get(l++);

		return x;
	}
}