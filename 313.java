public class Solution
{
	public int nthSuperUglyNumber(int n, int [] primes)
	{
		if(n < 1 || primes == null || primes.length == 0)
			return 0;

		List<Integer> list = new ArrayList<>();
		list.add(1);

		int [] idx = new int [primes.length];

		while(list.size() < n)
		{
			int min = Integer.MAX_VALUE;

			for(int i = 0;i < primes.length;i++)
				min = Math.min(min, primes[i] * list.get(idx[i]));

			list.add(min);

			for(int i = 0;i < primes.length;i++)
				if(primes[i] * list.get(idx[i]) == min)
					idx[i]++;
		}

		return list.get(n - 1);
	}
}