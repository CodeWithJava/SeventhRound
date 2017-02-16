public class Solution
{
	Map<Integer, Integer> map;

	public int fourSumCount(int [] A, int [] B, int [] C, int [] D)
	{
		if(A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0 || D == null || D.length == 0)
			return 0;

		map = new HashMap<>();

		for(int i = 0;i < A.length;i++)
		{
			for(int j = 0;j < B.length;j++)
			{
				map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
			}
		}

		int result = 0;

		for(int i = 0;i < C.length;i++)
			for(int j = 0;j < B.length;j++)
				result += map.getOrDefault(-1 * (C[i] + D[j]), 0);

		return result;
	}
}