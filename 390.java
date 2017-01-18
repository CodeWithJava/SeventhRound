public class Solution
{
	public int lastRemaining(int n)
	{
		if(n < 1)
			throw new IllegalArgumentException("Input must be non-negative");

		boolean left = true;

		int remaining = n;
		int step = 1;
		int head = 1;

		while(remaining > 1)
		{
			if(left || (remaing & 1) == 1)
				head += step;

			remaining /= 2;
			step *= 2;
			left = !left;
		}

		return head;
	}
}