public class Solution
{
	private static final int MOD = 1337;

	public int superPow(int a, int [] b)
	{
		if(b == null || b.length == 0)
			return 0;

		int result = 1;

		a %= MOD;

		for(int i = 0;i < b.length;i++)
			result = (superPow(result, 10) * superPow(a, b[i])) % MOD;

		return result;
	}

	private int superPow(int a, int b)
	{
		if(b == 0)
			return 1;

		if(b == 1)
			return a;

		int x = superPow(a, b / 2);

		x = (x * x) % MOD;

		if((b & 1) == 1)
			x = (x * a) % MOD;

		return x;
	}
}