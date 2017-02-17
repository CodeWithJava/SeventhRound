public class Solution
{
	public int numberOfArithmeticSlices(int [] A)
	{
		if(A == null || A.length < 3)
			return 0;

		int curr = 0;
		int sum = 0;

		for(int i = 2;i < A.length;i++)
		{
			if(A[i] - A[i - 1] == A[i - 1] - A[i - 2])
				sum += ++curr;
			else
				curr = 0;
		}

		return sum;
	}
}