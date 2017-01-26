public class Solution
{
	public int nthUglyNumber(int n)
	{
		if(n < 0)
			throw new IllegalArgumentException("Input is invalid");

		List<Integer> result = new ArrayList<>();
		result.add(1);

		int i = 0;
		int j = 0;
		int k = 0;

		while(result.size() < n)
		{
			int n2 = result.get(i) * 2;
			int n3 = result.get(j) * 3;
			int n5 = result.get(k) * 5;

			int min = Math.min(n2, Math.min(n3, n5));

			result.add(min);

			if(min == n2)
				i++;
			if(min == n3)
				j++;
			if(min == n5)
				k++;
		}

		return result.get(n - 1);
	}
}