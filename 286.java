public class Solution
{
	public void wallsAndGates(int [][] rooms)
	{
		if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
			return;

		int r = rooms.length;
		int c = rooms[0].length;

		boolean [][] visited = new boolean [r][c];

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				if(rooms[i][j] == 0)
					traversal(rooms, i, j, 0, visited);
	}

	private void traversal(int [][] rooms, int i, int j, int distance, boolean [][] visited)
	{
		if(i < 0 || i > rooms.length - 1 || j < 0 || j > rooms[0].length - 1)
			return;

		if(rooms[i][j] == -1)
			return;

		if(visited[i][j])
			return;

		if(distance > rooms[i][j])
			return;

		visited[i][j] = true;

		if(distance < rooms[i][j])
			rooms[i][j] = distance;

		traversal(rooms, i - 1, j, distance + 1, visited);
		traversal(rooms, i + 1, j, distance + 1, visited);
		traversal(rooms, i, j - 1, distance + 1, visited);
		traversal(rooms, i, j + 1, distance + 1, visited);

		visited[i][j] = false;
	}
}