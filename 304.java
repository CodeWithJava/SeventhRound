public class NumMatrix
{
	int [][] x;

	NumMatrix(int [][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		int r = matrix.length;
		int c = matrix[0].length;

		x = new int [r][c];

		for(int i = 0;i < r;i++)
		{
			int sum = 0;

			for(int j = 0;j < c;j++)
			{
				sum += matrix[i][j];

				x[i][j] = i == 0 ? sum:sum + x[i - 1][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2)
	{
		if(row1 == 0 && col1 == 0)
			return x[row2][col2];
		else if(row1 == 0)
			return x[row2][col2] - x[row2][col1 - 1];
		else if(col1 == 0)
			return x[row2][col2] - x[row1 - 1][col2];
		else
			return x[row2][col2] - x[row2][col1 - 1] - x[row1 - 1][col2] + x[row1 - 1][col1 - 1];
	}
}