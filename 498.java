public class Solution
{
	public int [] findDiagonalOrder(int [][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return new int [0];

		int r = matrix.length;
		int c = matrix[0].length;

		int row = 0;
		int col = 0;

		int [][] dir = {{-1, 1},{1, -1}};
		int p  = 0;

		int [] result = new int [r * c];

		for(int i = 0;i < result.length;i++)
		{
			result[i] = matrix[row][col];

			row += dir[p][0];
			col += dir[p][1];

			if(row >= r)
			{
				row = r - 1;
				col += 2;
				p = 1 - p;
			}

			if(col >= c)
			{
				col = c - 1;
				row += 2;
				p = 1 - p;
			}

			if(row < 0)
			{
				row = 0;
				p = 1 - p;
			}

			if(col < 0)
			{
				col = 0;
				p = 1 - p;
			}
		}

		return result;
	}
}