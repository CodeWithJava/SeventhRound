public class Solution extends GuessGame
{
	public int guessNumber(int n)
	{
		if(n < 1)
			return -1;

		int l = 1;
		int r = n;

		while(l < r)
		{
			int m = l + (r - l) / 2;

			if(guess(m) == -1)
				r = m - 1;
			else if(guess(m) == 1)
				l = m + 1;
			else
				return m;
		}

		return l;
	}
}