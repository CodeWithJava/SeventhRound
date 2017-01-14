public class Solution
{
	int count;

	public int totalNQueens(int n)
	{
		count = 0;

		if(n < 1)
			return 0;

		int [] col = new int [n];

		traversal(n, 0, col);

		return count;
	}

	private void traversal(int n, int row, int [] col)
	{
		if(row == n)
		{
			count++;
		}
		else
		{
			for(int i = 0;i < n;i++)
			{
				col[row] = i;

				if(isValid(row, col))
					traversal(n, row + 1, col);
			}
		}
	}

	private boolean isValid(int row, int [] col)
	{
		for(int i = 0;i < row;i++)
			if(col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i)
				return false;

		return true;
	}
}