public class NumMatrix
{
	int [][] x;
	int [][] bit;
	int r;
	int c;

	NumMatrix(int [][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		r = matrix.length;
		c = matrix[0].length;

		x = new int [r][c];
		bit = new int [r + 1][c + 1];

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				update(i, j, matrix[i][j]);
	}

	public void update(int row, int col, int val)
	{
		int delta = val - x[row][col];
		x[row][col] = val;

		for(int i = row + 1;i <= r;i += i & -i)
			for(int j = col + 1;j <= c;j += j & -j)
				bit[i][j] += delta;
	}

	public int sumRegion(int row1, int col1, int row2, int col2)
	{
		return query(row2,col2) - query(row1 - 1, col2) - query(row2, col1 - 1) + query(row1 - 1, col1 - 1);
	}

	private int query(int row, int col)
	{
		int sum = 0;

		for(int i = row + 1;i > 0;i -= i & -i)
			for(int j = col + 1;j > 0;j -= j & -j)
				sum += bit[i][j];

		return sum;
	}
}