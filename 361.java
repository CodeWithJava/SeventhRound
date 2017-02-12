public class Solution
{
	public int maxKilledEnemies(char [][] grid)
	{
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int r = grid.length;
		int c = grid[0].length;

		int result = 0;
		int rowHits = 0;
		int [] colHits = new int [c];

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(j == 0 || grid[i][j - 1] == 'W')
				{
					rowHits = 0;

					for(int k = j;k < c && grid[i][k] != 'W';k++)
						if(grid[i][k] == 'E')
							rowHits++;
				}

				if(i == 0 || grid[i - 1][j] == 'W')
				{
					colHits[j] = 0;

					for(int k = i;k < r && grid[k][j] != 'W';k++)
						if(grid[k][j] == 'E')
							colHits[j]++;
				}

				if(grid[i][j] == '0')
					result = Math.max(result, rowHits + colHits[j]);
			}
		}

		return result;
	}
}