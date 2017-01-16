public class Solution
{
	public boolean searchMatrix(int [][] matrix, int target)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int r = matrix.length;
		int c = matrix[0].length;

		if(target < matrix[0][0] || matrix[r - 1][c - 1] < target)
			return false;

		int i = 0;
		int j = r * c - 1;

		while(i <= j)
		{
			int m = i + (j - i) / 2;

			int x = m / c;
			int y = m % c;

			if(matrix[x][y] == target)
				return true;
			else if(matrix[x][y] < target)
				i = m + 1;
			else
				j = m - 1;
		}

		return false;
	}
}