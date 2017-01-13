public class Solution
{
	public void solveSudoku(char [][] board)
	{
		if(board == null || board.length != 9 || board[0].length != 9)
			return;

		solve(board);
	}

	private boolean solve(char [][] board)
	{
		for(int i = 0;i < board.length;i++)
		{
			for(int j = 0;j < board[0].length;j++)
			{
				if(board[i][j] == '.')
				{
					for(char x = '1';x <= '9';x++)
					{
						if(isValid(board, i, j, x))
						{
							board[i][j] = x;

							if(solve(board))
								return true;

							board[i][j] = '.';
						}
					}

					return false;
				}
			}
		}

		return true;
	}

	private boolean isValid(char [][] board, int r, int c, char x)
	{
		for(int j = 0;j < board[0].length;j++)
			if(board[r][j] == x)
				return false;

		for(int i = 0;i < board.length;i++)
			if(board[i][c] == x)
				return false;

		for(int i = r / 3 * 3;i < r / 3 * 3 + 3;i++)
			for(int j = c / 3 * 3;j < c / 3 * 3 + 3;j++)
				if(board[i][j] == x)
					return false;

		return true;
	}
}