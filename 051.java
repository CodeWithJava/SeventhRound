public class Solution
{
	List<List<String>> result;

	public List<List<String>> solveNQueens(int n)
	{
		result = new ArrayList<>();

		if(n < 1)
			return result;

		int [] col = new int [n];

		traversal(n, 0, col);

		return result;
	}

	private void traversal(int n, int row, int [] col)
	{
		if(row == n)
		{
			List<String> t = new ArrayList<>();

			for(int i = 0;i < n;i++)
			{
				StringBuilder sb = new StringBuilder();

				for(int j = 0;j < n;j++)
				{
					if(col[i] == j)
						sb.append('Q');
					else
						sb.append('.');
				}

				t.add(sb.toString());
			}

			result.add(new ArrayList<>(t));
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