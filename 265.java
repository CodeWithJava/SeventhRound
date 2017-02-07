public class Solution
{
	public int minCostII(int [][] costs)
	{
		if(costs == null || costs.length == 0)
			return 0;

		int prevMin = 0;
		int prevSec = 0;
		int prevIdx = -1;

		for(int i = 0;i < costs.length;i++)
		{
			int currMin = Integer.MAX_VALUE;
			int currSec = Integer.MAX_VALUE;
			int currIdx = -1;

			for(int j = 0;j < costs[0].length;j++)
			{
				costs[i][j] += prevIdx == j ? prevSec:prevMin;

				if(costs[i][j] < currMin)
				{
					currSec = currMin;
					currMin = costs[i][j];
					currIdx = j;
				}
				else if(costs[i][j] < currSec)
					currSec = costs[i][j];
			}

			prevMin = currMin;
			prevSec = currSec;
			prevIdx = currIdx;
		}

		return prevMin;
	}
}