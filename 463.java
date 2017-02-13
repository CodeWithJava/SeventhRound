public class Solution
{
	public int islandPerimeter(int [][] grid)
	{
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return -1;

		int r = grid.length;
		int c = grid[0].length;

		int islands = 0;
		int neighbours = 0;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(grid[i][j] == 1)
				{
					islands++;

					if(i < r - 1 && grid[i + 1][j] == 1)
						neighbours++;
					if(j < c - 1 && grid[i][j + 1] == 1)
						neighbours++;
				}
			}
		}

		return islands * 4 - neighbours * 2;
	}
}