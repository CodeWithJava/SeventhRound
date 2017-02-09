public class Solution
{
	public int longestIncreasingPath(int [][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int r = matrix.length;
		int c = matrix[0].length;

		int [][] dp = new int [r][c];

		int max = 0;

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				max = Math.max(max, traversal(matrix, i, j, 0, Integer.MIN_VALUE, dp));

		return max;
	}

	private int traversal(int [][] matrix, int i, int j, int length, int head, int [][] dp)
	{
		if(i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1 || matrix[i][j] <= head)
			return length;

		if(dp[i][j] > 0)
			return length + dp[i][j];

		int t = matrix[i][j];
		matrix[i][j] = Integer.MIN_VALUE;

		int l1 = traversal(matrix, i - 1, j, length + 1, t, dp);
		int l2 = traversal(matrix, i + 1, j, length + 1, t, dp);
		int l3 = traversal(matrix, i, j - 1, length + 1, t, dp);
		int l4 = traversal(matrix, i, j + 1, length + 1, t, dp);

		matrix[i][j] = t;

		dp[i][j] = Math.max(Math.max(l1, l2), Math.max(l3, l4)) - length;

		return length + dp[i][j];
	}
}