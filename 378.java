public class Solution
{
	public int kthSmallest(int [][] matrix, int k)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 0)
			throw new IllegalArgumentException("Input is invalid");

		int r = matrix.length;
		int c = matrix[0].length;

		int i = matrix[0][0];
		int j = matrix[r - 1][c - 1];

		while(i < j)
		{
			int m = i + (j - i) / 2;

			int x = traversal(matrix, m);

			if(x < k)
				i = m + 1;
			else
				j = m;
		}

		return j;
	}

	private int traversal(int [][] matrix, int m)
	{
		int count = 0;

		int i = matrix.length - 1;
		int j = 0;

		while(i >= 0 && j <= matrix[0].length - 1)
		{
			if(matrix[i][j] <= m)
			{
				count += i + 1;
				j++;
			}
			else
				i--;
		}

		return count;
	}
}