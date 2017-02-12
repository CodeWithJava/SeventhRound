public class Solution
{
	public int maxSumSubmatrix(int [][] matrix, int k)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return Integer.MIN_VALUE;

		int r = matrix.length;
		int c = matrix[0].length;

		int result = Integer.MIN_VALUE;

		for(int i = 0;i < r;i++)
		{
			int [] t = new int [c];

			for(int j = i;j >= 0;j--)
			{
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);

				int sum = 0;

				for(int p = 0;p < c;p++)
				{
					t[p] += matrix[j][p];
					sum += t[p];

					Integer ceiling = set.ceiling(sum - k);

					if(ceiling != null)
						result = Math.max(result, sum - ceiling);

					set.add(sum);
				}
			}
		}

		return result;
	}
}