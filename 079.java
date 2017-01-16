public class Solution
{
	public boolean exist(char [][] board, String word)
	{
		if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
			return false;

		int r = board.length;
		int c = board[0].length;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(traversal(board, i, j, 0, word))
					return true;
			}
		}

		return false;
	}

	private boolean traversal(char [][] board, int i, int j, int k, String word)
	{
		if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
			return false;

		if(board[i][j] == word.charAt(k))
		{
			char t = board[i][j];
			board[i][j] = '*';

			if(k == word.length() - 1)
				return true;
			else if(traversal(board, i - 1, j, k + 1, word) || traversal(board, i + 1, j, k + 1, word) || traversal(board, i, j - 1, k + 1, word) || traversal(board, i, j + 1, k + 1, word))
				return true;

			board[i][j] = t;
		}

		return false;
	}
}