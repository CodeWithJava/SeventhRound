public class Solution
{
	public int [][] generateMatrix(int n)
	{
		if(n < 1)
			return new int [0][0];

		int [][] matrix = new int [n][n];

		int x = 0;
		int y = 0;

		int k = 1;

		while(n > 0)
		{
			if(n == 1)
			{
				matrix[x][y] = k;
				break;
			}

			for(int i = 0;i < n - 1;i++)
				matrix[x][y++] = k++;

			for(int i = 0;i < n - 1;i++)
				matrix[x++][y] = k++;

			for(int i = 0;i < n - 1;i++)
				matrix[x][y--] = k++;

			for(int i = 0;i < n - 1;i++)
				matrix[x--][y] = k ++;

			x++;
			y++;

			n -= 2;
		}

		return matrix;
	}
}