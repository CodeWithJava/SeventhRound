public class Solution
{
	public int [][] multiply(int [][] A, int [][] B)
	{
		if(A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0 || A[0].length != B.length)
			return new int [0][0];

		int rA = A.length;
		int cA = A[0].length;
		int cB = B[0].length;

		int [][] matrix = new int [rA][cB];

		for(int i = 0;i < rA;i++)
		{
			for(int j = 0;j < cA;j++)
			{
				if(A[i][j] == 0)
					continue;

				for(int k = 0;k < cB;k++)
				{
					if(B[j][k] == 0)
						continue;

					matrix[i][k] += A[i][j] * B[j][k];
				}
			}
		}

		return matrix;
	}
}