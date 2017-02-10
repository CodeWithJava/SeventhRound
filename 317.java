public class Solution
{
	int [][] numReach;
	int [][] distance;

	public int shortestDistance(int [][] grid)
	{
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return -1;

		int r = grid.length;
		int c = grid[0].length;

		numReach = new int [r][c];
		distance = new int [r][c];

		int numBuildings = 0;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(grid[i][j] == 1)
				{
					Queue<Integer> q = new LinkedList<>();
					boolean [][] visited = new boolean [r][c];

					shortestDistance(grid, i, j, 0, q, visited);

					numBuildings++;
				}
			}
		}

		int min = Integer.MAX_VALUE;

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				if(grid[i][j] == 0 && numReach[i][j] == numBuildings)
					min = Math.min(min, distance[i][j]);

		return min == Integer.MAX_VALUE ? -1:min;
	}

	private void shortestDistance(int [][] grid, int x, int y, int currDistance, Queue<Integer> q, boolean [][] visited)
	{
		traversal(grid, x, y, x, y, currDistance, q, visited);

		int c = grid[0].length;

		while(!q.isEmpty())
		{
			int size = q.size();
			currDistance++;

			for(int k = 0;k < size;k++)
			{
				int n = q.poll();

				int i = n / c;
				int j = n % c;

				traversal(grid, x, y, i - 1, j, currDistance, q, visited);
				traversal(grid, x, y, i + 1, j, currDistance, q, visited);
				traversal(grid, x, y, i, j - 1, currDistance, q, visited);
				traversal(grid, x, y, i, j + 1, currDistance, q, visited);
			}
		}
	}

	private void traversal(int [][] grid, int x, int y, int i, int j, int currDistance, Queue<Integer> q, boolean [][] visited)
	{
		if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || visited[i][j])
			return;

		if((i != x || j != y) && grid[i][j] != 0)
			return;

		visited[i][j] = true;

		numReach[i][j]++;
		distance[i][j] += currDistance;

		q.offer(i * grid[0].length + j);
	}
}