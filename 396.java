public class Solution
{
	public int maxRotateFunction(int [] A)
	{
		if(A == null || A.length == 0)
			return 0;

		int allSum = 0;
		int l = A.length;
		int f = 0;

		for(int i = 0;i < l;i++)
		{
			f += i * A[i];
			allSum += A[i];
		}

		int max = f;

		for(int i = l - 1;i >= 1;i--)
		{
			f += allSum - l * A[i];
			max = Math.max(f, max);
		}

		return max;
	}
}