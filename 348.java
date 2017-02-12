public class TicTacToe
{
	int n;
	int [] r;
	int [] c;
	int diagonal;
	int antidiagonal;

	/** Initialize your data structure here. */
	public TicTacToe(int n)
	{
		r = new int [n];
		c = new int [n];
		this.n = n;
	}
	
	/** Player {player} makes a move at ({row}, {col}).
		@param row The row of the board.
		@param col The column of the board.
		@param player The player, can be either 1 or 2.
		@return The current winning condition, can be either:
			0: No one wins.
			1: Player 1 wins.
			2: Player 2 wins. */
	public int move(int row, int col, int player)
	{
		int toAdd = player == 1 ? 1:-1;

		r[row] += toAdd;
		c[col] += toAdd;

		if(row == col)
			diagonal += toAdd;

		if(row == n - 1 - col)
			antidiagonal += toAdd;

		if(Math.abs(r[row]) == n || Math.abs(c[col]) == n || Math.abs(diagonal) == n || Math.abs(antidiagonal) == n)
			return player;

		return 0;
	}
}