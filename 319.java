public class Solution
{
	public int bulbSwitch(int n)
	{
		if(n < 0)
			throw new IllegalArgumentException("Input must be non-negative");

		return (int)Math.sqrt(n);
	}
}