public class Solution
{
	public int canCompleteCircuit(int [] gas, int [] cost)
	{
		if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length)
			return -1;

		int sumRemaining = 0;
		int start = 0;
		int d = 0;

		for(int i = 0;i < gas.length;i++)
		{
			int remaining = gas[i] - cost[i];

			if(sumRemaining >= 0)
				sumRemaining += remaining;
			else
			{
				sumRemaining = remaining;
				start = i;
			}

			d += remaining;
		}

		if(d < 0)
			return -1;

		return start;
	}
}