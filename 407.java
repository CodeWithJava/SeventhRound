public class Solution
{
	public int trapRainWater(int [][] heights)
	{
		if(heights == null || heights.length == 0 || heights[0].length == 0)
			return 0;

		Queue<Cell> q = new PriorityQueue<>(new CellComparator());

		int r = heights.length;
		int c = heights[0].length;

		boolean [][] visited = new bollean [r][c];

		for(int i = 0;i < r;i++)
		{
			visited[i][0] = true;
			visited[i][c - 1] = true;
			q.offer(new Cell(i, 0, heights[i][0]));
			q.offer(new Cell(i, c - 1, heights[i][c - 1]));
		}

		for(int j = 0;j < c;j++)
		{
			visited[0][j] = true;
			visited[r - 1][j] = true;
			q.offer(new Cell(0, j, heights[0][j]));
			q.offer(new Cell(r - 1, j, heights[r - 1][j]));
		}

		int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int result = 0;

		while(!q.isEmtpy())
		{
			Cell cell = q.poll();

			for(int [] dir: dirs)
			{
				int row = cell.row + dir[0];
				int col = cell.col + dir[1];

				if(row >= 0 && row <= r - 1 && col >= 0 && col <= c - 1 && !visited[row][col])
				{
					visited[row][col] = true;
					result += Math.max(0, cell.height - heights[row][col]);
					q.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
				}
			}
		}

		return result;
	}
}
class CellComparator extends Comparator<Cell>
{
	public int compare(Cell c1, Cell c2)
	{
		return c1.height - c2.height;
	}
}
class Cell
{
	int row;
	int col;
	int height;

	Cell(int row, int col, int height)
	{
		this.row = row;
		this.col = col;
		this.height = height;
	}
}