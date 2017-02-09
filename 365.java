public class Solution
{
	public boolean canMeasureWater(int x, int y, int z)
	{
		if(x < 0 || y < 0 || z < 0)
			return false;

		return x + y == z || x + y > z && z % gcd(x, y) == 0;
	}

	private int gcd(int x, int y)
	{
		if(x < y)
			return gcd(y, x);

		if(y == 0)
			return x;

		return gcd(y, x % y);
	}
}