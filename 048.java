public class Solution
{
	public void rotate(int [][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		int r = matrix.length;
		int c = matrix[0].length;

		int [][] t = new int [r][c];

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				t[i][j] = matrix[i][j];

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				matrix[i][j] = t[r - j - 1][i];
	}
}